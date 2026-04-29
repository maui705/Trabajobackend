package com.example.trabajo2.dtos;

import java.time.LocalDate;

public class UsuarioDTO {

    private int Usuario_Id;
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Password;
    private Boolean Estado;
    private LocalDate FechaRegistro;


    public int getUsuario_Id() {return Usuario_Id;}

    public void setUsuario_Id(int usuario_Id) {Usuario_Id = usuario_Id;}

    public String getNombre() {return Nombre;}

    public void setNombre(String nombre) {Nombre = nombre;}

    public String getApellido() {return Apellido;}

    public void setApellido(String apellido) {Apellido = apellido;}

    public String getEmail() {return Email;}

    public void setEmail(String email) {Email = email;}

    public String getPassword() {return Password;}

    public void setPassword(String password) {Password = password;}

    public Boolean getEstado() {return Estado;}

    public void setEstado(Boolean estado) {Estado = estado;}

    public LocalDate getFechaRegistro() {return FechaRegistro;}

    public void setFechaRegistro(LocalDate fechaRegistro) {FechaRegistro = fechaRegistro;}
}
