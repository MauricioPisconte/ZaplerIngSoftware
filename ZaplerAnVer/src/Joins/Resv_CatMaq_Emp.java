package Joins;

public class Resv_CatMaq_Emp {
    private int CodigoVendedor;
    private int Inv_Id;
    private float Cantidad;
    private String Modelo;

    public Resv_CatMaq_Emp(int codigoVendedor, int inv_Id, float cantidad, String modelo) {
        CodigoVendedor = codigoVendedor;
        Inv_Id = inv_Id;
        Cantidad = cantidad;
        Modelo = modelo;
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

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }
}
