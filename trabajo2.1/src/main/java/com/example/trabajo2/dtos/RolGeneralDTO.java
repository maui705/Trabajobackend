package com.example.trabajo2.dtos;

import java.time.LocalDate;

public class RolGeneralDTO {
    private int RolId;
    private String NombreRol;
    private String Descripcion;
    private float Sueldo;
    private String Permisos;
    private LocalDate FechaCreacion;

    public int getRolId() { return RolId; }
    public void setRolId(int rolId) { RolId = rolId; }

    public String getNombreRol() { return NombreRol; }
    public void setNombreRol(String nombreRol) { NombreRol = nombreRol; }

    public String getDescripcion() { return Descripcion; }
    public void setDescripcion(String descripcion) { Descripcion = descripcion; }

    public float getSueldo() { return Sueldo; }
    public void setSueldo(float sueldo) { Sueldo = sueldo; }

    public String getPermisos() { return Permisos; }
    public void setPermisos(String permisos) { Permisos = permisos; }

    public LocalDate getFechaCreacion() {return FechaCreacion;}
    public void setFechaCreacion(LocalDate fechaCreacion) {FechaCreacion = fechaCreacion;}
}