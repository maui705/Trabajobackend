package pe.edu.upc.kurona.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "AImagenes")
public class AImagenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idImagen;

    @Column(name = "nombreImagen", length = 100, nullable = false)
    private String nombreImagen;

    @Column(name = "urlImagen", length = 250, nullable = false)
    private String urlImagen;

    @Column(name = "fechaSubida", nullable = false)
    private LocalDate fechaSubida;

    @Column(name = "analisisIA", length = 250, nullable = false)
    private String analisisIA;

    @Column(name = "estadoProcesamiento", nullable = false)
    private boolean estadoProcesamiento;

    public AImagenes() {
    }

    public AImagenes(int idImagen, String nombreImagen, String urlImagen, LocalDate fechaSubida, String analisisIA, boolean estadoProcesamiento) {
        this.idImagen = idImagen;
        this.nombreImagen = nombreImagen;
        this.urlImagen = urlImagen;
        this.fechaSubida = fechaSubida;
        this.analisisIA = analisisIA;
        this.estadoProcesamiento = estadoProcesamiento;
    }

    public boolean isEstadoProcesamiento() {
        return estadoProcesamiento;
    }

    public void setEstadoProcesamiento(boolean estadoProcesamiento) {
        this.estadoProcesamiento = estadoProcesamiento;
    }

    public String getAnalisisIA() {
        return analisisIA;
    }

    public void setAnalisisIA(String analisisIA) {
        this.analisisIA = analisisIA;
    }

    public LocalDate getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(LocalDate fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public int getIdImagen() {return idImagen;}

    public void setIdImagen(int idImagen) {this.idImagen = idImagen;}
}

