package Entidades;

public class Pedido {
    private int CodigoVendedor;
    private int Inv_Id;
    private float Cantidad;

    public Pedido(int codigoVendedor, int inv_Id, float cantidad) {
        CodigoVendedor = codigoVendedor;
        Inv_Id = inv_Id;
        Cantidad = cantidad;
    }

    public int getCodigoVendedor() {
        return CodigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        CodigoVendedor = codigoVendedor;
    }

    public int getInv_Id() {
        return Inv_Id;
    }

    public void setInv_Id(int inv_Id) {
        Inv_Id = inv_Id;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float cantidad) {
        Cantidad = cantidad;
    }
}
