package com.example.trabajo2.dtos;


public class QueryNativeDTO {
    private String NombreRol;
    private int RolId;
    private int quantityUsuarios;

    public String getNombreRol() {
        return NombreRol;
    }

    public void setNombreRol(String nombreRol) {
        NombreRol = nombreRol;
    }

    public int getRolId() {return RolId;}

    public void setRolId(int rolId) {
        RolId = rolId;
    }

    public int getQuantityUsuarios() {
        return quantityUsuarios;
    }

    public void setQuantityUsuarios(int quantityUsuarios) {
        this.quantityUsuarios = quantityUsuarios;
    }
}
