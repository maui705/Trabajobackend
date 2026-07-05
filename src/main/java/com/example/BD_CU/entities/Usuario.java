package com.example.BD_CU.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
//oficial
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_Id;

    @Column(name = "username",length =100 ,nullable = false)
    private String username;

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

    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "user_id")
    //private List<Rol> roles;
    @OneToMany(mappedBy = "usuarios", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Rol> roles;

    public Usuario() {
    }

    public Usuario(int usuario_Id, String username, int extras, String apellido, String email, String password, Boolean estado, LocalDate fechaRegistro, List<Rol> roles) {
        this.usuario_Id = usuario_Id;
        this.username = username;
        this.extras = extras;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.roles = roles;
    }

    public int getUsuario_Id() {
        return usuario_Id;
    }

    public void setUsuario_Id(int usuario_Id) {
        this.usuario_Id = usuario_Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
