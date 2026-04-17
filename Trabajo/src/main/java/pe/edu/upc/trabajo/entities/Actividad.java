package pe.edu.upc.trabajo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Actividadid;

    @Column(name = "Descripcion",length =100 ,nullable = false)
    private String Descripcion;

    @Column(name = "FechaInicio",nullable = false)
    private LocalDate FechaInicio;

    @Column(name = "FechaFin",nullable = false)
    private LocalDate FechaFin;

    @Column(name = "Responsable",length =150 ,nullable = false)
    private String Responsable;

    @Column(name = "Estado" ,length =150, nullable = false)
    private String Estado;

    public Actividad() {
    }

    public Actividad(int actividadid, String descripcion, LocalDate fechaInicio, LocalDate fechafin, String responsable, String estado){
        Actividadid = actividadid;
        Descripcion = descripcion;
        FechaInicio = fechaInicio;
        FechaFin = fechafin;
        Responsable = responsable;
        Estado = estado;
    }

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
