package com.example.trabajo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Lote")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Loteid;

    @Column(name = "Ubicacion",length =100 ,nullable = false)
    private String Ubicacion;

    @Column(name = "Tamaño",length =50 ,nullable = false)
    private String Tamaño;

    @Column(name = "Variedadcafe",length =100 ,nullable = false)
    private String Variedadcafe;

    @Column(name = "Observacion",length =150 ,nullable = false)
    private String Observacion;

    @Column(name = "Estado" ,length =150, nullable = false)
    private String Estado;

    public Lote() {
    }

    public Lote(int loteid, String ubicacion, String tamaño, String variedadcafe, String observacion, String estado) {
        Loteid = loteid;
        Ubicacion = ubicacion;
        Tamaño = tamaño;
        Variedadcafe = variedadcafe;
        Observacion = observacion;
        Estado = estado;
    }

    public int getLoteid() {
        return Loteid;
    }

    public void setLoteid(int loteid) {
        Loteid = loteid;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getTamaño() {
        return Tamaño;
    }

    public void setTamaño(String tamaño) {
        Tamaño = tamaño;
    }

    public String getVariedadcafe() {
        return Variedadcafe;
    }

    public void setVariedadcafe(String variedadcafe) {
        Variedadcafe = variedadcafe;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
