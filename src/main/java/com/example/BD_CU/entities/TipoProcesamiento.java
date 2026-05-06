package com.example.BD_CU.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoProcesamiento")
public class TipoProcesamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoId;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    public TipoProcesamiento() {
    }

    public TipoProcesamiento(int tipoId, String nombre, String descripcion) {
        this.tipoId = tipoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}