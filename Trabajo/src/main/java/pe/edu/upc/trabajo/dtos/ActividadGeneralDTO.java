package pe.edu.upc.trabajo.dtos;

import java.security.PrivateKey;
import java.time.LocalDate;

public class ActividadGeneralDTO {
    private int Actividadid;
    private String Descripcion;
    private LocalDate FechaInicio;
    private LocalDate FechaFin;
    private String Responsable;
    private String Estado;

    public int getActividadid() {
        return Actividadid;
    }

    public void setActividadid(int actividadid) {
        Actividadid = actividadid;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String responsable) {
        Responsable = responsable;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
