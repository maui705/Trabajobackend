package com.example.trabajo.dtos;

public class RolDTO {
    private String NombreRol;
    private String Descripcion;
    private float Sueldo;

    public String getNombreRol() { return NombreRol; }
    public void setNombreRol(String nombreRol) { NombreRol = nombreRol; }

    public String getDescripcion() { return Descripcion; }
    public void setDescripcion(String descripcion) { Descripcion = descripcion; }

    public float getSueldo() { return Sueldo; }
    public void setSueldo(float sueldo) { Sueldo = sueldo; }
}