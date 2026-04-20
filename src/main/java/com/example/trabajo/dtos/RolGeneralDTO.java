package com.example.trabajo.dtos;

import java.time.LocalDateTime;

public class RolGeneralDTO {
    private int RolId;
    private String NombreRol;
    private String Descripcion;
    private float Sueldo;
    private float Extras;
    private String Permisos;
    private LocalDateTime FechaCreacion;

    public int getRolId() { return RolId; }
    public void setRolId(int rolId) { RolId = rolId; }

    public String getNombreRol() { return NombreRol; }
    public void setNombreRol(String nombreRol) { NombreRol = nombreRol; }

    public String getDescripcion() { return Descripcion; }
    public void setDescripcion(String descripcion) { Descripcion = descripcion; }

    public float getSueldo() { return Sueldo; }
    public void setSueldo(float sueldo) { Sueldo = sueldo; }

    public float getExtras() { return Extras; }
    public void setExtras(float extras) { Extras = extras; }

    public String getPermisos() { return Permisos; }
    public void setPermisos(String permisos) { Permisos = permisos; }

    public LocalDateTime getFechaCreacion() { return FechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { FechaCreacion = fechaCreacion; }
}