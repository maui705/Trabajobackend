package com.example.trabajo.dtos;

import jakarta.persistence.Column;

public class TipoProcesamientoDTO {

    private String Nombre;
    private String Descripcion;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
