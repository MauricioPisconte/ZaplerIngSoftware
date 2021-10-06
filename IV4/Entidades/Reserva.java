package Entidades;

public class Reserva {
    private int ID_Reserva;
    private int CodigoVendedor;
    private int Inv_Id;
    private float Cantidad;
    private int ID_ListaReservas;

    public Reserva(int ID_Reserva, int CodigoVendedor, int Inv_Id, float Cantidad, int ID_ListaReservas) {
        this.ID_Reserva = ID_Reserva;
        this.CodigoVendedor = CodigoVendedor;
        this.Inv_Id = Inv_Id;
        this.Cantidad = Cantidad;
        this.ID_ListaReservas = ID_ListaReservas;
    }
    
    public Reserva(){
    }

    public int getID_Reserva() {
        return ID_Reserva;
    }

    public void setID_Reserva(int ID_Reserva) {
        this.ID_Reserva = ID_Reserva;
    }

    public int getCodigoVendedor() {
        return CodigoVendedor;
    }

    public void setCodigoVendedor(int CodigoVendedor) {
        this.CodigoVendedor = CodigoVendedor;
    }

    public int getInv_Id() {
        return Inv_Id;
    }

    public void setInv_Id(int Inv_Id) {
        this.Inv_Id = Inv_Id;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getID_ListaReservas() {
        return ID_ListaReservas;
    }

    public void setID_ListaReservas(int ID_ListaReservas) {
        this.ID_ListaReservas = ID_ListaReservas;
    }

    
}
