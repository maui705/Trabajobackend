package com.example.BD_CU.dtos;

public class QueryNative2DTO {

    private int usuario_Id;
    private String nombre;
    private String apellido;
    private int sueldoTotal;

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

    public int getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(int sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }
}

