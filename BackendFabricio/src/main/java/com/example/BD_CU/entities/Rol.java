package com.example.BD_CU.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rolId;

    @Column(name = "nombreRol", length = 100, nullable = false)
    private String nombreRol;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "sueldo", nullable = false)
    private int sueldo;

    @Column(name = "permisos", length = 100, nullable = false)
    private String permisos;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDate fechaCreacion;

    public Rol() {}

    public Rol(int rolId, String nombreRol, String descripcion, int sueldo, String permisos, LocalDate fechaCreacion) {
        this.rolId = rolId;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.sueldo = sueldo;
        this.permisos = permisos;
        this.fechaCreacion = fechaCreacion;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}