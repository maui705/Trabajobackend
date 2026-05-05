package pe.edu.upc.kurona.dtos;

import pe.edu.upc.kurona.Entities.Lote;

import java.time.LocalDate;

public class AImagenesDTO {
    private int idAImagenes;
    private LocalDate fechaAnalisis;
    private String formato;
    private String defectosEncontrados;
    private boolean estado;
    private Lote lote;

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
}
