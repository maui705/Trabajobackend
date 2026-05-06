package com.example.BD_CU.dtos;

import java.time.LocalDate;

public class ProcesamientoDTO {

    private int procesamientoId;
    private int idCosecha;
    private int tipoId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private float cantidad;
    private String estado;

    public int getProcesamientoId() {
        return procesamientoId;
    }

    public void setProcesamientoId(int procesamientoId) {
        this.procesamientoId = procesamientoId;
    }

    public int getIdCosecha() {
        return idCosecha;
    }

    public void setIdCosecha(int idCosecha) {
        this.idCosecha = idCosecha;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
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