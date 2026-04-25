package com.example.trabajo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Cosecha")
public class Cosecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCosecha;

    @Column(name = "cantidad",nullable = false)
    private int cantidad;
    @Column(name = "estadoCosecha",length = 230,nullable = false)
    private String estadoCosecha;
    @Column(name = "firmaElectronica",length = 130,nullable = false)
    private String firmaElectronica;
    @Column(name = "responsable",length = 100,nullable = false)
    private String responsable;
    @Column(name = "metodos",length = 130,nullable = false)
    private String metodos;

    @ManyToOne
    @JoinColumn(name="loteId")
    private Lote lote;

    public Cosecha() {
    }

    public Cosecha(int idCosecha, int cantidad, String estadoCosecha, String firmaElectronica, String responsable, String metodos, Lote lote) {
        this.idCosecha = idCosecha;
        this.cantidad = cantidad;
        this.estadoCosecha = estadoCosecha;
        this.firmaElectronica = firmaElectronica;
        this.responsable = responsable;
        this.metodos = metodos;
        this.lote = lote;
    }

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

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }
}
