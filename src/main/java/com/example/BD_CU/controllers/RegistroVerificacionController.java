package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.RegistroRequestDTO;
import com.example.BD_CU.dtos.VerificarRegistroDTO;
import com.example.BD_CU.servicesinterfaces.IRegistroVerificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registro")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistroVerificacionController {

    @Autowired
    private IRegistroVerificacionService registroVerificacionService;

    @PostMapping("/enviar-codigo")
    public String enviarCodigo(@Valid @RequestBody RegistroRequestDTO dto) {
        return registroVerificacionService.enviarCodigoRegistro(dto);
    }

    @PostMapping("/verificar")
    public String verificarRegistro(@Valid @RequestBody VerificarRegistroDTO dto) {
        return registroVerificacionService.verificarYRegistrar(dto);
    }
}