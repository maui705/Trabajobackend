package com.example.BD_CU.dtos;

public class UsuarioGeneralDTO {

    private int Usuario_Id;
    private int Rol_Id;
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Password;
    private Boolean Estado;

    public int getUsuario_Id() {return Usuario_Id;}

    public void setUsuario_Id(int usuario_Id) {Usuario_Id = usuario_Id;}

    public int getRol_Id() {return Rol_Id;}

    public void setRol_Id(int rol_Id) {Rol_Id = rol_Id;}

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
}
