package com.example.trabajo.dtos;

public class TipoProcesamientoGeneralDTO {
    private int TipoId;
    private String Nombre;
    private String Descripcion;

    public int getTipoId() {
        return TipoId;
    }

    public void setTipoId(int tipoId) {
        TipoId = tipoId;
    }

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
