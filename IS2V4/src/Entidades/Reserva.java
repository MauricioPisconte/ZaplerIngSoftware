package Entidades;

public class Reserva {
    private int CodigoVendedor;
    private int Inv_Id;
    private float Cantidad;
    private int ID_ListaReservas;

    public Reserva(int codigoVendedor, int inv_Id, float cantidad, int ID_ListaReservas) {
        CodigoVendedor = codigoVendedor;
        Inv_Id = inv_Id;
        Cantidad = cantidad;
        this.ID_ListaReservas = ID_ListaReservas;
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

    public int getID_ListaReservas() {
        return ID_ListaReservas;
    }

    public void setID_ListaReservas(int ID_ListaReservas) {
        this.ID_ListaReservas = ID_ListaReservas;
    }
}
