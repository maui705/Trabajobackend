package com.example.BD_CU.dtos;


public class QueryNativeDTO {
    private String nombreRol;
    private int rolId;
    private int quantityUsuarios;

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getQuantityUsuarios() {
        return quantityUsuarios;
    }

    public void setQuantityUsuarios(int quantityUsuarios) {
        this.quantityUsuarios = quantityUsuarios;
    }
}