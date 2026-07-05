package com.example.trabajo2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

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
    private int Sueldo;

    @Column(name = "Permisos", length = 100, nullable = false)
    private String Permisos;

    @Column(name = "FechaCreacion", nullable = false)
    private LocalDate FechaCreacion;

    public Rol() {}


    public Rol(int rolId, String nombreRol, String descripcion, int sueldo, String permisos, LocalDate fechaCreacion) {
        RolId = rolId;
        NombreRol = nombreRol;
        Descripcion = descripcion;
        Sueldo = sueldo;
        Permisos = permisos;
        FechaCreacion = fechaCreacion;
    }

    public int getRolId() { return RolId; }
    public void setRolId(int rolId) { RolId = rolId; }

    public String getNombreRol() { return NombreRol; }
    public void setNombreRol(String nombreRol) { NombreRol = nombreRol; }

    public String getDescripcion() { return Descripcion; }
    public void setDescripcion(String descripcion) { Descripcion = descripcion; }

    public int getSueldo() {return Sueldo;}
    public void setSueldo(int sueldo) {Sueldo = sueldo;}


    public String getPermisos() { return Permisos; }
    public void setPermisos(String permisos) { Permisos = permisos; }

    public LocalDate getFechaCreacion() {return FechaCreacion;}
    public void setFechaCreacion(LocalDate fechaCreacion) {FechaCreacion = fechaCreacion;}
}
