package pe.edu.upc.kurona.dtos;

public class DefectosPorLoteDTO {
    private String ubicacion;
    private String defecto;
    private int cantidad;

    public DefectosPorLoteDTO() {
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDefecto() {
        return defecto;
    }

    public void setDefecto(String defecto) {
        this.defecto = defecto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
