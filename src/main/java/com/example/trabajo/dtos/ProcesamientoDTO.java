package com.example.trabajo.dtos;

public class ProcesamientoDTO {
    private String Metodo;
    private float Cantidad;
    private String Estado;

    public String getMetodo() { return Metodo; }
    public void setMetodo(String metodo) { Metodo = metodo; }

    public float getCantidad() { return Cantidad; }
    public void setCantidad(float cantidad) { Cantidad = cantidad; }

    public String getEstado() { return Estado; }
    public void setEstado(String estado) { Estado = estado; }
}