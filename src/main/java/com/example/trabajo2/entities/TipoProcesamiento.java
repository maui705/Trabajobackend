package com.example.trabajo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoProcesamiento")
public class TipoProcesamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TipoId;

    @Column(name = "Nombre", length = 100, nullable = false)
    private String Nombre;

    @Column(name = "Descripcion", length = 100, nullable = false)
    private String Descripcion;

    public TipoProcesamiento() {}

    public int getTipoId() { return TipoId; }
    public void setTipoId(int tipoId) { TipoId = tipoId; }
    public String getNombre() { return Nombre; }
    public void setNombre(String nombre) { Nombre = nombre; }
    public String getDescripcion() { return Descripcion; }
    public void setDescripcion(String descripcion) { Descripcion = descripcion; }
}