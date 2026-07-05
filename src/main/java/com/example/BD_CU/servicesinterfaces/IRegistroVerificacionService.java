package com.example.BD_CU.servicesinterfaces;

import com.example.BD_CU.dtos.RegistroRequestDTO;
import com.example.BD_CU.dtos.VerificarRegistroDTO;

public interface IRegistroVerificacionService {

    String enviarCodigoRegistro(RegistroRequestDTO dto);

    String verificarYRegistrar(VerificarRegistroDTO dto);
}