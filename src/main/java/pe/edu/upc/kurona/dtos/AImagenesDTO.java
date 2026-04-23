package pe.edu.upc.kurona.dtos;

import java.time.LocalDate;

public class AImagenesDTO {
    private int idImagen;
    private String nombreImagen;
    private String urlImagen;
    private LocalDate fechaSubida;
    private String analisisIA;
    private boolean estadoProcesamiento;

    public int getIdImagen() { return idImagen; }
    public void setIdImagen(int idImagen) { this.idImagen = idImagen; }
    public String getNombreImagen() { return nombreImagen; }
    public void setNombreImagen(String nombreImagen) { this.nombreImagen = nombreImagen; }
    public String getUrlImagen() { return urlImagen; }
    public void setUrlImagen(String urlImagen) { this.urlImagen = urlImagen; }
    public LocalDate getFechaSubida() { return fechaSubida; }
    public void setFechaSubida(LocalDate fechaSubida) { this.fechaSubida = fechaSubida; }
    public String getAnalisisIA() { return analisisIA; }
    public void setAnalisisIA(String analisisIA) { this.analisisIA = analisisIA; }
    public boolean isEstadoProcesamiento() { return estadoProcesamiento; }
    public void setEstadoProcesamiento(boolean estadoProcesamiento) { this.estadoProcesamiento = estadoProcesamiento; }
}
