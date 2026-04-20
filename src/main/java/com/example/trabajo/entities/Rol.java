package com.example.trabajo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RolId;

    @Column(name = "NombreRol", length = 100, nullable = false)
    private String NombreRol;

    @Column(name = "Descripcion", length = 100, nullable = false)
    private String Descripcion;

    @Column(name = "Sueldo", nullable = false)
    private float Sueldo;

    @Column(name = "Extras")
    private float Extras;

    @Column(name = "Permisos", length = 100)
    private String Permisos;

    @Column(name = "FechaCreacion", nullable = false)
    private LocalDateTime FechaCreacion;

    public Rol() {}

    public Rol(int rolId, String nombreRol, String descripcion, float sueldo, float extras, String permisos, LocalDateTime fechaCreacion) {
        RolId = rolId;
        NombreRol = nombreRol;
        Descripcion = descripcion;
        Sueldo = sueldo;
        Extras = extras;
        Permisos = permisos;
        FechaCreacion = fechaCreacion;
    }

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