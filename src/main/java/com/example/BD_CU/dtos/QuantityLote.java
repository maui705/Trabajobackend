package com.example.BD_CU.dtos;

public class QuantityLote {
    private int loteId;
    private String ubicacion;
    private String variedadCafe;
    private  int quantity;

    public int getLoteId() {
        return loteId;
    }

    public void setLoteId(int loteId) {
        this.loteId = loteId;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getVariedadCafe() {
        return variedadCafe;
    }

    public void setVariedadCafe(String variedadCafe) {
        this.variedadCafe = variedadCafe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
