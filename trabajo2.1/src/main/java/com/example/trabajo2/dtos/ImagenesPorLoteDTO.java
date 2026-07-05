package com.example.trabajo2.dtos;

public class ImagenesPorLoteDTO {
    private int loteId;
    private int cantidadImagenes;

    public int getLoteId() {
        return loteId;
    }

    public void setLoteId(int loteId) {
        this.loteId = loteId;
    }

    public int getCantidadImagenes() {
        return cantidadImagenes;
    }

    public void setCantidadImagenes(int cantidadImagenes) {
        this.cantidadImagenes = cantidadImagenes;
    }
}
