package com.example.trabajo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Lote")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int LoteId;

    @Column(name = "Ubicacion", length = 200, nullable = false)
    private String Ubicacion;

    @Column(name = "Tamaño", nullable = false)
    private float Tamaño;

    @Column(name = "VariedadCafe", length = 200, nullable = false)
    private String VariedadCafe;

    @Column(name = "Observacion", length = 200, nullable = false)
    private String Observacion;

    @Column(name = "Estado", length = 200, nullable = false)
    private String Estado;

    public Lote() {}

    public Lote(int loteId, String ubicacion, float tamaño, String variedadCafe, String observacion, String estado) {
        LoteId = loteId;
        Ubicacion = ubicacion;
        Tamaño = tamaño;
        VariedadCafe = variedadCafe;
        Observacion = observacion;
        Estado = estado;
    }

    public int getLoteId() { return LoteId; }
    public void setLoteId(int loteId) { LoteId = loteId; }
    public String getUbicacion() { return Ubicacion; }
    public void setUbicacion(String ubicacion) { Ubicacion = ubicacion; }
    public float getTamaño() { return Tamaño; }
    public void setTamaño(float tamaño) { Tamaño = tamaño; }
    public String getVariedadCafe() { return VariedadCafe; }
    public void setVariedadCafe(String variedadCafe) { VariedadCafe = variedadCafe; }
    public String getObservacion() { return Observacion; }
    public void setObservacion(String observacion) { Observacion = observacion; }
    public String getEstado() { return Estado; }
    public void setEstado(String estado) { Estado = estado; }
}