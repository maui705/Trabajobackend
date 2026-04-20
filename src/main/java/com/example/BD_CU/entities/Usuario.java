package com.example.BD_CU.entities;

import jakarta.persistence.*;

import java.time.DateTimeException;
import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Usuario_Id;

    @Column(name = "Rol_Id",length =50 ,nullable = false)
    private int Rol_Id;

    @Column(name = "Nombre",length =100 ,nullable = false)
    private String Nombre;

    @Column(name = "Apellido",length =100 ,nullable = false)
    private String Apellido;

    @Column(name = "Email",length =100 ,nullable = false)
    private String Email;

    @Column(name = "Password",length =100 ,nullable = false)
    private String Password;

    @Column(name = "Estado",length =100 ,nullable = false)
    private Boolean Estado;

    @Column(name = "FechaRegistro",length =100 ,nullable = false)
    private LocalDate FechaRegistro;

    public Usuario() {
    }

    public Usuario(int usuario_Id, int rol_Id, String nombre, String apellido, String email, String password, Boolean estado, LocalDate fechaRegistro) {
        Usuario_Id = usuario_Id;
        Rol_Id = rol_Id;
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Password = password;
        Estado = estado;
        FechaRegistro = fechaRegistro;
    }

    public int getUsuario_Id() {
        return Usuario_Id;
    }

    public void setUsuario_Id(int usuario_Id) {
        Usuario_Id = usuario_Id;
    }

    public int getRol_Id() {
        return Rol_Id;
    }

    public void setRol_Id(int rol_Id) {
        Rol_Id = rol_Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }

    public LocalDate getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        FechaRegistro = fechaRegistro;
    }
}
