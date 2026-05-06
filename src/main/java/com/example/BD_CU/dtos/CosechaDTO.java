package com.example.BD_CU.dtos;

import com.example.BD_CU.entities.Lote;

public class CosechaDTO {
    private int idCosecha;
    private int cantidad;
    private String estadoCosecha;
    private String firmaElectronica;
    private String responsable;
    private String metodos;
    private int loteId;


    public int getIdCosecha() {
        return idCosecha;
    }

    public void setIdCosecha(int idCosecha) {
        this.idCosecha = idCosecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstadoCosecha() {
        return estadoCosecha;
    }

    public void setEstadoCosecha(String estadoCosecha) {
        this.estadoCosecha = estadoCosecha;
    }

    public String getFirmaElectronica() {
        return firmaElectronica;
    }

    public void setFirmaElectronica(String firmaElectronica) {
        this.firmaElectronica = firmaElectronica;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getMetodos() {
        return metodos;
    }

    public void setMetodos(String metodos) {
        this.metodos = metodos;
    }

    public int getLoteId() {return loteId;}

    public void setLoteId(int loteId) {this.loteId = loteId;}
}
