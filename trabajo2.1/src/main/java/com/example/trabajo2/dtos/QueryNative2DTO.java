package com.example.trabajo2.dtos;

public class QueryNative2DTO {

    private int Usuario_Id;
    private String Nombre;
    private String Apellido;
    private int SueldoTotal;


    public int getUsuario_Id() {
        return Usuario_Id;
    }

    public void setUsuario_Id(int usuario_Id) {
        Usuario_Id = usuario_Id;
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

    public int getSueldoTotal() {
        return SueldoTotal;
    }

    public void setSueldoTotal(int sueldoTotal) {
        SueldoTotal = sueldoTotal;
    }
}
