package Joins;

public class Maq_CatMaq {
    private String Tipo;
    private int costo;
    private String Marca;
    private String Modelo;
    private String NombreProveedor;
    private String Estado;
    private Float Descuento;
    private int Stock;

    public Maq_CatMaq(String tipo, int costo, String marca, String modelo, String nombreProveedor, String estado, Float descuento, int stock) {
        Tipo = tipo;
        this.costo = costo;
        Marca = marca;
        Modelo = modelo;
        NombreProveedor = nombreProveedor;
        Estado = estado;
        Descuento = descuento;
        Stock = stock;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getNombreProveedor() {
        return NombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        NombreProveedor = nombreProveedor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Float getDescuento() {
        return Descuento;
    }

    public void setDescuento(Float descuento) {
        Descuento = descuento;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }
}
