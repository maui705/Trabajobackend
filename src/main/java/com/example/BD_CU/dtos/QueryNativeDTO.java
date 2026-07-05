package com.example.BD_CU.dtos;


public class QueryNativeDTO {
    private String nombreRol;
    private int quantityUsuarios;

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public int getQuantityUsuarios() {
        return quantityUsuarios;
    }

    public void setQuantityUsuarios(int quantityUsuarios) {
        this.quantityUsuarios = quantityUsuarios;
    }
}
