package com.example.trabajo2.dtos;

import jakarta.persistence.Column;

public class LoteDTO {

    private String ubicacion;
    private int tamaño;
    private String variedadCafe;
    private String observacion;
    private String estado;

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getVariedadCafe() {
        return variedadCafe;
    }

    public void setVariedadCafe(String variedadCafe) {
        this.variedadCafe = variedadCafe;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
