package com.example.BD_CU.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "rol"})})
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rolId;

    @Column(name = "rol", length = 100, nullable = false)
    private String rol;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "sueldo", nullable = false)
    private int sueldo;

    @Column(name = "permisos", length = 100, nullable = false)
    private String permisos;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuarios;

    public Rol() {
    }

    public Rol(int rolId, String rol, String descripcion, int sueldo, String permisos, LocalDate fechaCreacion, Usuario usuarios) {
        this.rolId = rolId;
        this.rol = rol;
        this.descripcion = descripcion;
        this.sueldo = sueldo;
        this.permisos = permisos;
        this.fechaCreacion = fechaCreacion;
        this.usuarios = usuarios;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
}
