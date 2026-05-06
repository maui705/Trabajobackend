package com.example.BD_CU.dtos;

public class QuantityActividad {
    private String variedadCafe;
    private String Responsable;
    private String Estado;
    private int quantityActividad;

    public String getVariedadCafe() {
        return variedadCafe;
    }

    public void setVariedadCafe(String variedadCafe) {
        this.variedadCafe = variedadCafe;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String responsable) {
        Responsable = responsable;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }


    public int getQuantityActividad() {
        return quantityActividad;
    }

    public void setQuantityActividad(int quantityActividad) {
        this.quantityActividad = quantityActividad;
    }
}
