package com.example.BD_CU.dtos;

import java.time.LocalDate;

public class AImagenesDTO {
    private int idAImagenes;
    private LocalDate fechaAnalisis;
    private String formato;
    private String defectosEncontrados;
    private boolean estado;
    private int loteId;

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

    public int getLoteId() {return loteId;}

    public void setLoteId(int loteId) {this.loteId = loteId;}
}
