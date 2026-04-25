package com.example.trabajo.dtos;

import java.time.LocalDateTime;

public class ProcesamientoGeneralDTO {
    private int ProcesamientoId;
    private int CosechaId;
    private int TipoId;
    private LocalDateTime FechaInicio;
    private LocalDateTime FechaFin;
    private String Metodo;
    private float Cantidad;
    private String Estado;

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