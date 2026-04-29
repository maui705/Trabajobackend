package pe.edu.upc.kurona.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Lote")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLote;
    @Column(name = "Ubicacion", length = 150, nullable = false)
    private String ubicacion;

    @Column(name = "Tamaño", length = 50, nullable = false) // Mapeado a "Tamaño" en la BD
    private String tamano;

    @Column(name = "VariedadCafe", length = 100, nullable = false)
    private String variedadCafe;

    @Column(name = "Observaciones", length = 250, nullable = true)
    private String observaciones;

    @Column(name = "Estado", nullable = false)
    private boolean estado;

    public Lote() {
    }

    public Lote(int idLote, String ubicacion, String tamano, String variedadCafe, String observaciones, boolean estado) {
        this.idLote = idLote;
        this.ubicacion = ubicacion;
        this.tamano = tamano;
        this.variedadCafe = variedadCafe;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getVariedadCafe() {
        return variedadCafe;
    }

    public void setVariedadCafe(String variedadCafe) {
        this.variedadCafe = variedadCafe;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
