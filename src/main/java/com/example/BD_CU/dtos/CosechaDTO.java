package com.example.BD_CU.dtos;

public class CosechaDTO {

    private int LoteId;
    private float Cantidad;
    private String Estado;
    private String Observaciones;
    private String Responsable;
    private String Metodo;

    public int getLoteId() {
        return LoteId;
    }

    public void setLoteId(int loteId) {
        LoteId = loteId;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float cantidad) {
        Cantidad = cantidad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String responsable) {
        Responsable = responsable;
    }

    public String getMetodo() {
        return Metodo;
    }

    public void setMetodo(String metodo) {
        Metodo = metodo;
    }
}
