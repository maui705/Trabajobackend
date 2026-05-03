package com.example.trabajo2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Procesamiento")
public class Procesamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int procesamientoId;

    @ManyToOne
    @JoinColumn(name = "idCosecha", nullable = false)
    private Cosecha cosecha;

    @ManyToOne
    @JoinColumn(name = "tipoId", nullable = false)
    private TipoProcesamiento tipoProcesamiento;

    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Column(name = "metodo", length = 20)
    private String metodo;

    @Column(name = "cantidad")
    private float cantidad;

    @Column(name = "estado", length = 20)
    private String estado;

    public Procesamiento() {
    }

    public Procesamiento(int procesamientoId, Cosecha cosecha, TipoProcesamiento tipoProcesamiento, LocalDate fechaInicio, LocalDate fechaFin, String metodo, float cantidad, String estado) {
        this.procesamientoId = procesamientoId;
        this.cosecha = cosecha;
        this.tipoProcesamiento = tipoProcesamiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.metodo = metodo;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public int getProcesamientoId() {
        return procesamientoId;
    }

    public void setProcesamientoId(int procesamientoId) {
        this.procesamientoId = procesamientoId;
    }

    public Cosecha getCosecha() {
        return cosecha;
    }

    public void setCosecha(Cosecha cosecha) {
        this.cosecha = cosecha;
    }

    public TipoProcesamiento getTipoProcesamiento() {
        return tipoProcesamiento;
    }

    public void setTipoProcesamiento(TipoProcesamiento tipoProcesamiento) {
        this.tipoProcesamiento = tipoProcesamiento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}