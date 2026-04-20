package com.example.trabajo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Procesamiento")
public class Procesamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProcesamientoId;

    @Column(name = "CosechaId", nullable = false)
    private int CosechaId;

    @Column(name = "TipoId", nullable = false)
    private int TipoId;

    @Column(name = "FechaInicio")
    private LocalDateTime FechaInicio;

    @Column(name = "FechaFin")
    private LocalDateTime FechaFin;

    @Column(name = "Metodo", length = 20)
    private String Metodo;

    @Column(name = "Cantidad")
    private float Cantidad;

    @Column(name = "Estado", length = 20)
    private String Estado;

    public Procesamiento() {}

    public Procesamiento(int procesamientoId, int cosechaId, int tipoId, LocalDateTime fechaInicio, LocalDateTime fechaFin, String metodo, float cantidad, String estado) {
        ProcesamientoId = procesamientoId;
        CosechaId = cosechaId;
        TipoId = tipoId;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        Metodo = metodo;
        Cantidad = cantidad;
        Estado = estado;
    }

    public int getProcesamientoId() { return ProcesamientoId; }
    public void setProcesamientoId(int procesamientoId) { ProcesamientoId = procesamientoId; }

    public int getCosechaId() { return CosechaId; }
    public void setCosechaId(int cosechaId) { CosechaId = cosechaId; }

    public int getTipoId() { return TipoId; }
    public void setTipoId(int tipoId) { TipoId = tipoId; }

    public LocalDateTime getFechaInicio() { return FechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { FechaInicio = fechaInicio; }

    public LocalDateTime getFechaFin() { return FechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { FechaFin = fechaFin; }

    public String getMetodo() { return Metodo; }
    public void setMetodo(String metodo) { Metodo = metodo; }

    public float getCantidad() { return Cantidad; }
    public void setCantidad(float cantidad) { Cantidad = cantidad; }

    public String getEstado() { return Estado; }
    public void setEstado(String estado) { Estado = estado; }
}