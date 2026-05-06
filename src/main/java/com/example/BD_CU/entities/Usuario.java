package com.example.BD_CU.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_Id;

    @Column(name = "nombre",length =100 ,nullable = false)
    private String nombre;

    @Column(name = "extras", nullable = false)
    private int extras;

    @Column(name = "apellido",length =100 ,nullable = false)
    private String apellido;

    @Column(name = "email",length =100 ,nullable = false)
    private String email;

    @Column(name = "password",length =100 ,nullable = false)
    private String password;

    @Column(name = "estado",length =100 ,nullable = false)
    private Boolean estado;

    @Column(name = "fechaRegistro",length =100 ,nullable = false)
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "rolId")
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int usuario_Id, String nombre, int extras, String apellido, String email, String password, Boolean estado, LocalDate fechaRegistro, Rol rol) {
        this.usuario_Id = usuario_Id;
        this.nombre = nombre;
        this.extras = extras;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.rol = rol;
    }

    public int getUsuario_Id() {
        return usuario_Id;
    }

    public void setUsuario_Id(int usuario_Id) {
        this.usuario_Id = usuario_Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
