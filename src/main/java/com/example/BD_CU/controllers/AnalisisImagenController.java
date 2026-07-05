package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.AnalisisImagenResponseDTO;

import com.example.BD_CU.servicesinterfaces.GeminiVisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.UUID;


@RestController
@RequestMapping("/api/imagen")
public class AnalisisImagenController {

    @Autowired
    private GeminiVisionService visionService;

    // Carpeta local donde se guardan las imágenes (relativa a donde corre el .jar)
    @Value("${app.upload.dir:uploads/imagenes}")
    private String uploadDir;

    @PostMapping(value = "/analizar-imagen", consumes = "multipart/form-data")
    // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> analizarImagen(@RequestParam("imagen") MultipartFile imagen) {
        try {
            if (imagen.isEmpty()) {
                return ResponseEntity.badRequest().body("La imagen está vacía.");
            }

            String contentType = imagen.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                return ResponseEntity.badRequest().body("El archivo debe ser una imagen.");
            }

            String mediaType = normalizarMediaType(contentType);
            String formato = mediaType.substring(mediaType.indexOf("/") + 1).toUpperCase();
            if ("JPEG".equals(formato)) {
                formato = "JPG";
            }

            // Guardar la imagen en una carpeta local del servidor
            Path directorio = Paths.get(uploadDir);
            if (!Files.exists(directorio)) {
                Files.createDirectories(directorio);
            }
            String nombreArchivo = UUID.randomUUID() + "_" + imagen.getOriginalFilename();
            Path rutaArchivo = directorio.resolve(nombreArchivo);
            Files.copy(imagen.getInputStream(), rutaArchivo, StandardCopyOption.REPLACE_EXISTING);

            // Analizar defectos con IA de visión (Gemini)
            String defectos = visionService.analizarDefectos(imagen.getBytes(), mediaType);

            AnalisisImagenResponseDTO respuesta = new AnalisisImagenResponseDTO();
            respuesta.setFechaAnalisis(LocalDate.now());
            respuesta.setFormato(formato);
            respuesta.setDefectosEncontrados(defectos);
            respuesta.setRutaImagen(rutaArchivo.toString());

            return ResponseEntity.ok(respuesta);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar la imagen: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al analizar la imagen: " + e.getMessage());
        }
    }

    private String normalizarMediaType(String contentType) {
        String tipo = contentType.toLowerCase();
        if (tipo.contains("png")) return "image/png";
        if (tipo.contains("gif")) return "image/gif";
        if (tipo.contains("webp")) return "image/webp";
        return "image/jpeg";
    }
}
