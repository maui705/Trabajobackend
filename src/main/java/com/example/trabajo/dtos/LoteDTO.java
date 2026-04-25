package com.example.trabajo.dtos;

public class LoteDTO {
    private String Ubicacion;
    private float Tamaño;
    private String VariedadCafe;
    private String Observacion;
    private String Estado;

    public String getUbicacion() { return Ubicacion; }
    public void setUbicacion(String ubicacion) { Ubicacion = ubicacion; }
    public float getTamaño() { return Tamaño; }
    public void setTamaño(float tamaño) { Tamaño = tamaño; }
    public String getVariedadCafe() { return VariedadCafe; }
    public void setVariedadCafe(String variedadCafe) { VariedadCafe = variedadCafe; }
    public String getObservacion() { return Observacion; }
    public void setObservacion(String observacion) { Observacion = observacion; }
    public String getEstado() { return Estado; }
    public void setEstado(String estado) { Estado = estado; }
}