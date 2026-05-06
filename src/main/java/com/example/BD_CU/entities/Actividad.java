package com.example.BD_CU.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actividadid;

    @Column(name = "Descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "FechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "FechaFin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "Responsable", length = 150, nullable = false)
    private String responsable;

    @Column(name = "Estado", length = 150, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn
            (name = "loteId")
    private Lote lote;

    @ManyToOne
    @JoinColumn
            (name = "Usuario_Id")
    private Usuario usuario;

    public Actividad() {
    }

    public Actividad(int actividadid, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String responsable, String estado, Lote lote, Usuario usuario) {
        this.actividadid = actividadid;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.responsable = responsable;
        this.estado = estado;
        this.lote = lote;
        this.usuario = usuario;
    }

    public int getActividadid() {
        return actividadid;
    }

    public void setActividadid(int actividadid) {
        this.actividadid = actividadid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
