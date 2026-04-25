package com.example.trabajo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Procesamiento")
public class Procesamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProcesamientoId;

    @ManyToOne
    @JoinColumn(name = "CosechaId", nullable = false)
    private Cosecha cosecha;

    @ManyToOne
    @JoinColumn(name = "TipoId", nullable = false)
    private TipoProcesamiento tipoProcesamiento;

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

    public int getProcesamientoId() { return ProcesamientoId; }
    public void setProcesamientoId(int procesamientoId) { ProcesamientoId = procesamientoId; }
    public Cosecha getCosecha() { return cosecha; }
    public void setCosecha(Cosecha cosecha) { this.cosecha = cosecha; }
    public TipoProcesamiento getTipoProcesamiento() { return tipoProcesamiento; }
    public void setTipoProcesamiento(TipoProcesamiento tipoProcesamiento) { this.tipoProcesamiento = tipoProcesamiento; }
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