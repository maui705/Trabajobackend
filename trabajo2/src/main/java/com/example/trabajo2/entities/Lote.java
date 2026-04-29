package com.example.trabajo2.entities;

import jakarta.persistence.*;


@Entity
@Table(name="Lote")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loteId;

    @Column(name = "ubicacion",length =200 ,nullable = false)
    private String ubicacion;

    @Column(name = "tamaño" ,nullable = false)
    private int tamaño;

    @Column(name = "variedadCafe",length =200 ,nullable = false)
    private String variedadCafe;

    @Column(name = "observacion",length =200 ,nullable = false)
    private String observacion;

    @Column(name = "estado",length =200 ,nullable = false)
    private String estado;

    public Lote() {
    }

    public Lote(int loteId, String ubicacion, int tamaño, String variedadCafe, String observacion, String estado) {
        this.loteId = loteId;
        this.ubicacion = ubicacion;
        this.tamaño = tamaño;
        this.variedadCafe = variedadCafe;
        this.observacion = observacion;
        this.estado = estado;
    }

    public int getLoteId() {
        return loteId;
    }

    public void setLoteId(int loteId) {
        this.loteId = loteId;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getVariedadCafe() {
        return variedadCafe;
    }

    public void setVariedadCafe(String variedadCafe) {
        this.variedadCafe = variedadCafe;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
