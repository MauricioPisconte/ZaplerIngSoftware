package Entidades;

public class ContactoVendProv {
    private int CodVendedor;
    private int RucProveedor;
    private String fechaU;

    public ContactoVendProv(int codVendedor, int rucProveedor, String fechaU) {
        CodVendedor = codVendedor;
        RucProveedor = rucProveedor;
        this.fechaU = fechaU;
    }

    public int getCodVendedor() {
        return CodVendedor;
    }

    public void setCodVendedor(int codVendedor) {
        CodVendedor = codVendedor;
    }

    public int getRucProveedor() {
        return RucProveedor;
    }

    public void setRucProveedor(int rucProveedor) {
        RucProveedor = rucProveedor;
    }

    public String getFechaU() {
        return fechaU;
    }

    public void setFechaU(String fechaU) {
        this.fechaU = fechaU;
    }
}
