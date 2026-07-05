package com.example.BD_CU.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "AImagenes")
public class AImagenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAImagenes; // Corresponde a AImagenes_id

    @Column(name = "FechaAnalisis", nullable = false)
    private LocalDate fechaAnalisis;

    @Column(name = "Formato", length = 20, nullable = false)
    private String formato;

    @Column(name = "DefectosEncontrados", length = 2000, nullable = false)
    private String defectosEncontrados;

    @Column(name = "Estado", nullable = false)
    private boolean estado;
    // NUEVO: ruta donde se guardó la imagen analizada en el servidor
    @Column(name = "RutaImagen", length = 255)
    private String rutaImagen;


    @ManyToOne
    @JoinColumn(name = "loteId") // Relación con la tabla de Mauricio
    private Lote lote;

    public AImagenes() {
    }

    public AImagenes(int idAImagenes, LocalDate fechaAnalisis, String formato, String defectosEncontrados, boolean estado, String rutaImagen, Lote lote) {
        this.idAImagenes = idAImagenes;
        this.fechaAnalisis = fechaAnalisis;
        this.formato = formato;
        this.defectosEncontrados = defectosEncontrados;
        this.estado = estado;
        this.rutaImagen = rutaImagen;
        this.lote = lote;
    }

    public int getIdAImagenes() {
        return idAImagenes;
    }

    public void setIdAImagenes(int idAImagenes) {
        this.idAImagenes = idAImagenes;
    }

    public LocalDate getFechaAnalisis() {
        return fechaAnalisis;
    }

    public void setFechaAnalisis(LocalDate fechaAnalisis) {
        this.fechaAnalisis = fechaAnalisis;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDefectosEncontrados() {
        return defectosEncontrados;
    }

    public void setDefectosEncontrados(String defectosEncontrados) {
        this.defectosEncontrados = defectosEncontrados;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}

