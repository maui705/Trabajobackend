package com.example.BD_CU.dtos;

public class QuantityCosecha {
    private int idCosecha;
    private int cantidad;
    private String ubicacion;
    private int quantityCosecha;

    public int getQuantityCosecha() {
        return quantityCosecha;
    }

    public void setQuantityCosecha(int quantityCosecha) {
        this.quantityCosecha = quantityCosecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCosecha() {
        return idCosecha;
    }

    public void setIdCosecha(int idCosecha) {
        this.idCosecha = idCosecha;
    }
}
