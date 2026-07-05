package com.example.BD_CU.servicesimplement;

import com.example.BD_CU.dtos.RegistroRequestDTO;
import com.example.BD_CU.dtos.VerificarRegistroDTO;
import com.example.BD_CU.repositories.IUsuarioRepository;
import com.example.BD_CU.servicesinterfaces.IRegistroVerificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RegistroVerificacionServiceImplement implements IRegistroVerificacionService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    private final Map<String, String> codigos = new ConcurrentHashMap<>();
    private final Map<String, LocalDateTime> expiraciones = new ConcurrentHashMap<>();

    @Override
    public String enviarCodigoRegistro(RegistroRequestDTO dto) {

        String email = dto.getEmail().trim().toLowerCase();

        if (usuarioRepository.buscarEmail(email) > 0) {
            return "El correo ya está registrado";
        }

        String codigo = generarCodigo();

        codigos.put(email, codigo);
        expiraciones.put(email, LocalDateTime.now().plusMinutes(5));

        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(email);
        mensaje.setSubject("Código de verificación");
        mensaje.setText("Tu código de verificación es: " + codigo + "\n\nEste código vence en 5 minutos.");

        mailSender.send(mensaje);

        return "Código enviado al correo";
    }

    @Override
    public String verificarYRegistrar(VerificarRegistroDTO dto) {

        String email = dto.getEmail().trim().toLowerCase();

        if (!codigos.containsKey(email)) {
            return "No se encontró una solicitud de verificación para este correo";
        }

        if (LocalDateTime.now().isAfter(expiraciones.get(email))) {
            limpiarDatos(email);
            return "El código expiró";
        }

        if (!codigos.get(email).equals(dto.getCodigo())) {
            return "Código incorrecto";
        }

        limpiarDatos(email);

        return "Correo verificado correctamente";
    }

    private String generarCodigo() {
        SecureRandom random = new SecureRandom();
        int numero = random.nextInt(900000) + 100000;
        return String.valueOf(numero);
    }

    private void limpiarDatos(String email) {
        codigos.remove(email);
        expiraciones.remove(email);
    }
}