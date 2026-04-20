package com.example.BD_CU.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Cosecha")
public class Cosecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Cosecha_Id;

    @Column(name = "LoteId",length =50 ,nullable = false)
    private int LoteId;

    @Column(name = "Cantidad",length =50 ,nullable = false)
    private float Cantidad;

    @Column(name = "Estado",length =50 ,nullable = false)
    private String Estado;

    @Column(name = "Observaciones",length =150 ,nullable = false)
    private String Observaciones;

    @Column(name = "Responsable" ,length =50, nullable = false)
    private String Responsable;

    @Column(name = "Metodo" ,length =50, nullable = false)
    private String Metodo;

    public Cosecha() {
    }

    public Cosecha(int cosecha_Id, int loteId, float cantidad, String estado, String observaciones, String responsable, String metodo) {
        Cosecha_Id = cosecha_Id;
        LoteId = loteId;
        Cantidad = cantidad;
        Estado = estado;
        Observaciones = observaciones;
        Responsable = responsable;
        Metodo = metodo;
    }

    public int getCosecha_Id() {
        return Cosecha_Id;
    }

    public void setCosecha_Id(int cosecha_Id) {
        Cosecha_Id = cosecha_Id;
    }

    public int getLoteId() {
        return LoteId;
    }

    public void setLoteId(int loteId) {
        LoteId = loteId;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float cantidad) {
        Cantidad = cantidad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String responsable) {
        Responsable = responsable;
    }

    public String getMetodo() {
        return Metodo;
    }

    public void setMetodo(String metodo) {
        Metodo = metodo;
    }
}
