package com.example.trabajo2.dtos;

import jakarta.persistence.Column;

public class CosechaDTO {
    private int idCosecha;
    private int cantidad;
    private String estadoCosecha;
    private String firmaElectronica;
    private String responsable;
    private String metodos;

    public int getIdCosecha() {
        return idCosecha;
    }

    public void setIdCosecha(int idCosecha) {
        this.idCosecha = idCosecha;
    }

    public String getMetodos() {
        return metodos;
    }

    public void setMetodos(String metodos) {
        this.metodos = metodos;
    }
}
