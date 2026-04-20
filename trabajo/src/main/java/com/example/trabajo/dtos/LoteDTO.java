package com.example.trabajo.dtos;

import jakarta.persistence.Column;

public class LoteDTO {

    private String Ubicacion;
    private String Tamaño;
    private String Variedadcafe;
    private String Observacion;
    private String Estado;

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getTamaño() {
        return Tamaño;
    }

    public void setTamaño(String tamaño) {
        Tamaño = tamaño;
    }

    public String getVariedadcafe() {
        return Variedadcafe;
    }

    public void setVariedadcafe(String variedadcafe) {
        Variedadcafe = variedadcafe;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
