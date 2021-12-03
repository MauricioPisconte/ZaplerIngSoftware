package Entidades;

public class Maquinaria {
    private int Inv_Id;
    private String Estado;
    private Float Descuento;
    private int Stock;
    private int NAlmacen;
    private int IdMaq;
    private int RUCProveedor;

    public Maquinaria(int inv_Id, String estado, Float descuento, int stock, int NAlmacen, int idMaq, int RUCProveedor) {
        Inv_Id = inv_Id;
        Estado = estado;
        Descuento = descuento;
        Stock = stock;
        this.NAlmacen = NAlmacen;
        IdMaq = idMaq;
        this.RUCProveedor = RUCProveedor;
    }

    public int getInv_Id() {
        return Inv_Id;
    }

    public void setInv_Id(int inv_Id) {
        Inv_Id = inv_Id;
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

    public int getNAlmacen() {
        return NAlmacen;
    }

    public void setNAlmacen(int NAlmacen) {
        this.NAlmacen = NAlmacen;
    }

    public int getIdMaq() {
        return IdMaq;
    }

    public void setIdMaq(int idMaq) {
        IdMaq = idMaq;
    }

    public int getRUCProveedor() {
        return RUCProveedor;
    }

    public void setRUCProveedor(int RUCProveedor) {
        this.RUCProveedor = RUCProveedor;
    }
}
