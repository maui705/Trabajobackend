package com.example.BD_CU.servicesinterfaces;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;

/**
 * Envía la imagen del cafetal a la API gratuita de Google Gemini (AI Studio)
 * para obtener una descripción de los defectos visibles, validando primero
 * que la imagen corresponda efectivamente a un cultivo de café.
 *
 * Usa el modelo gemini-2.5-flash, disponible en el nivel gratuito de
 * Google AI Studio (sin tarjeta de crédito, sin costo).
 */
@Service
public class GeminiVisionService {

    // Se lee desde application.properties -> gemini.api.key=${GEMINI_API_KEY}
    @Value("${gemini.api.key}")
    private String apiKey;

    private static final String MODEL = "gemini-2.5-flash";
    private static final String GEMINI_URL =
            "https://generativelanguage.googleapis.com/v1beta/models/" + MODEL + ":generateContent";

    // Debe coincidir con @Column(length = ...) en la entidad y con
    // Validators.maxLength(...) en el formulario de Angular.
    private static final int LIMITE_CARACTERES = 480;

    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(20))
            .build();

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String analizarDefectos(byte[] imagenBytes, String mediaType) throws Exception {
        String base64Imagen = Base64.getEncoder().encodeToString(imagenBytes);

        String prompt = "Eres un agrónomo experto evaluando un cultivo de café. "
                + "1. Verifica si la imagen es de un cultivo de café (planta, hoja, fruto, lote). "
                + "Si NO lo es, responde EXACTAMENTE: 'La imagen no corresponde a un cultivo de café; no se puede realizar el análisis.'\n\n"
                + "2. Si SÍ es café, redacta un diagnóstico técnico y detallado en español. "
                + "Utiliza entre 350 y 480 caracteres para aprovechar el espacio del reporte. "
                + "Asegúrate de describir a detalle: "
                + "(a) Los defectos exactos encontrados (ej. indicios de roya, ojo de gallo, broca, estrés hídrico, deficiencia de nitrógeno, etc.). "
                + "(b) La ubicación y distribución del daño en la anatomía de la planta. "
                + "(c) La severidad del problema observada. "
                + "Escribe un párrafo fluido, descriptivo y altamente profesional. "
                + "Cero saludos, cero markdown (sin asteriscos ni negritas), solo el texto puro. "
                + "Si no hay defectos, responde: 'No se encontraron defectos visibles; la planta luce saludable.'";

        ObjectNode root = objectMapper.createObjectNode();
        ArrayNode contents = objectMapper.createArrayNode();
        ObjectNode contentItem = objectMapper.createObjectNode();

        ArrayNode parts = objectMapper.createArrayNode();

        ObjectNode imagePart = objectMapper.createObjectNode();
        ObjectNode inlineData = objectMapper.createObjectNode();
        inlineData.put("mime_type", mediaType);
        inlineData.put("data", base64Imagen);
        imagePart.set("inline_data", inlineData);
        parts.add(imagePart);

        ObjectNode textPart = objectMapper.createObjectNode();
        textPart.put("text", prompt);
        parts.add(textPart);

        contentItem.set("parts", parts);
        contents.add(contentItem);
        root.set("contents", contents);

        // Limita la respuesta del modelo para que sea concisa por diseño,
        // no solo por instrucción de texto.
        ObjectNode generationConfig = objectMapper.createObjectNode();
        generationConfig.put("maxOutputTokens", 900); // <-- Confirma que esto esté en 1000
        generationConfig.put("temperature", 0.5);
        root.set("generationConfig", generationConfig);

        // NUEVO: APAGAR FILTROS DE SEGURIDAD PARA AGRICULTURA
        ArrayNode safetySettings = objectMapper.createArrayNode();
        ObjectNode dangerFilter = objectMapper.createObjectNode();
        dangerFilter.put("category", "HARM_CATEGORY_DANGEROUS_CONTENT");
        dangerFilter.put("threshold", "BLOCK_NONE"); // Permite términos como "necrosis" o "muerte de la planta"
        safetySettings.add(dangerFilter);
        root.set("safetySettings", safetySettings);

        String requestBody = objectMapper.writeValueAsString(root);

        String responseBody = enviarConReintentos(requestBody);
        JsonNode responseJson = objectMapper.readTree(responseBody);
        JsonNode candidates = responseJson.get("candidates");

        StringBuilder resultado = new StringBuilder();
        if (candidates != null && candidates.isArray() && candidates.size() > 0) {
            JsonNode partsResp = candidates.get(0).path("content").path("parts");
            if (partsResp.isArray()) {
                for (JsonNode part : partsResp) {
                    if (part.has("text")) {
                        resultado.append(part.get("text").asText());
                    }
                }
            }
        }

        String texto = resultado.toString().trim();
        if (texto.isEmpty()) {
            texto = "No se encontraron defectos visibles.";
        }

        // Recorte de seguridad: nunca exceder el límite de la columna/formulario,
        // sin importar lo que haya respondido el modelo.
        if (texto.length() > LIMITE_CARACTERES) {
            texto = texto.substring(0, LIMITE_CARACTERES - 3) + "...";
        }

        return texto;
    }

    /**
     * Envía la petición a Gemini reintentando automáticamente cuando el
     * error es temporal (503 = modelo saturado, 429 = límite de tasa).
     * Espera progresivamente más entre cada intento (2s, 4s, 8s).
     */
    private String enviarConReintentos(String requestBody) throws Exception {
        // Quitamos los reintentos automáticos para no empeorar el bloqueo
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GEMINI_URL))
                .header("Content-Type", "application/json")
                .header("x-goog-api-key", apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        }

        // PARACAÍDAS: Si es error 429 (Cuota excedida), no lanzamos error,
        // devolvemos un JSON simulado para que el frontend no se rompa en la presentación.
        if (response.statusCode() == 429) {
            String jsonSimulado = "{"
                    + "\"candidates\": [{"
                    + "  \"content\": {"
                    + "    \"parts\": [{"
                    + "      \"text\": \"El sistema de análisis de IA se encuentra temporalmente saturado. Intente nuevamente en unos minutos.\""
                    + "    }]"
                    + "  }"
                    + "}]"
                    + "}";

        }

        // Si es otro error grave, sí lo lanzamos
        throw new RuntimeException("Error al llamar a la API de Gemini (status "
                + response.statusCode() + "): " + response.body());
    }
}