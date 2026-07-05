package com.example.BD_CU.dtos;

import java.time.LocalDate;

public class AnalisisImagenResponseDTO {

    private LocalDate fechaAnalisis;
    private String formato;
    private String defectosEncontrados;
    private String rutaImagen;

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

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
