package com.example.trabajo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Cosecha")
public class Cosecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CosechaId;

    @Column(name = "Cantidad", nullable = false)
    private float Cantidad;

    @Column(name = "EstadoCosecha", length = 230, nullable = false)
    private String EstadoCosecha;

    @Column(name = "FirmaElectronica", length = 130)
    private String FirmaElectronica;

    @Column(name = "Responsable", length = 100, nullable = false)
    private String Responsable;

    @Column(name = "Metodos", length = 130, nullable = false)
    private String Metodos;

    @ManyToOne
    @JoinColumn(name = "LoteId")
    private Lote lote;

    public Cosecha() {}

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
    public Lote getLote() { return lote; }
    public void setLote(Lote lote) { this.lote = lote; }
}