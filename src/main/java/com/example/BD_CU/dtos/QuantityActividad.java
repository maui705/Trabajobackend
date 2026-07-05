package com.example.BD_CU.dtos;

public class QuantityActividad {
    private int loteId;
    private String variedadCafe;
    private int quantityActividad;

    public String getVariedadCafe() {
        return variedadCafe;
    }

    public void setVariedadCafe(String variedadCafe) {
        this.variedadCafe = variedadCafe;
    }

    public int getQuantityActividad() {
        return quantityActividad;
    }

    public void setQuantityActividad(int quantityActividad) {
        this.quantityActividad = quantityActividad;
    }

    public int getLoteId() {
        return loteId;
    }

    public void setLoteId(int loteId) {
        this.loteId = loteId;
    }
}
