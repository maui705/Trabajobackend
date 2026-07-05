package com.example.BD_CU.dtos;

public class QuantityCosecha {
    private String estadoCosecha;
    private int quantityCosecha;

    public int getQuantityCosecha() {
        return quantityCosecha;
    }

    public void setQuantityCosecha(int quantityCosecha) {
        this.quantityCosecha = quantityCosecha;
    }

    public String getEstadoCosecha() {
        return estadoCosecha;
    }

    public void setEstadoCosecha(String estadoCosecha) {
        this.estadoCosecha = estadoCosecha;
    }
}
