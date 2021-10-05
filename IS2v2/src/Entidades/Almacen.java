package Entidades;

public class Almacen {
    private int NAlmacen;
    private String Ubicacion;

    public Almacen(int NAlmacen, String ubicacion) {
        this.NAlmacen = NAlmacen;
        Ubicacion = ubicacion;
    }

    public int getNAlmacen() {
        return NAlmacen;
    }

    public void setNAlmacen(int NAlmacen) {
        this.NAlmacen = NAlmacen;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }
}
