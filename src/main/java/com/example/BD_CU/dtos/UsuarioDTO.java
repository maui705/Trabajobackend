package com.example.BD_CU.dtos;

import com.example.BD_CU.entities.Rol;

import java.time.LocalDate;

public class UsuarioDTO {

    private int usuario_Id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Boolean estado;
    private LocalDate fechaRegistro;
    private int extras;
    private int rolId;

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

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
}
