package com.example.trabajo.dtos;

public class CosechaDTO {
    private int CosechaId;
    private float Cantidad;
    private String EstadoCosecha;
    private String FirmaElectronica;
    private String Responsable;
    private String Metodos;
    private int LoteId;

    public int getCosechaId() { return CosechaId; }
    public void setCosechaId(int cosechaId) { CosechaId = cosechaId; }
    public float getCantidad() { return Cantidad; }
    public void setCantidad(float cantidad) { Cantidad = cantidad; }
    public String getEstadoCosecha() { return EstadoCosecha; }
    public void setEstadoCosecha(String estadoCosecha) { EstadoCosecha = estadoCosecha; }
    public String getFirmaElectronica() { return FirmaElectronica; }
    public void setFirmaElectronica(String firmaElectronica) { FirmaElectronica = firmaElectronica; }
    public String getResponsable() { return Responsable; }
    public void setResponsable(String responsable) { Responsable = responsable; }
    public String getMetodos() { return Metodos; }
    public void setMetodos(String metodos) { Metodos = metodos; }
    public int getLoteId() { return LoteId; }
    public void setLoteId(int loteId) { LoteId = loteId; }
}