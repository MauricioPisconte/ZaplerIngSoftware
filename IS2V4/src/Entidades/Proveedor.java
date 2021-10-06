package Entidades;

public class Proveedor {
    private int RucProveedor;
    private String NombreProveedor;

    public Proveedor(int rucProveedor, String nombreProveedor) {
        RucProveedor = rucProveedor;
        NombreProveedor = nombreProveedor;
    }

    public int getRucProveedor() {
        return RucProveedor;
    }

    public void setRucProveedor(int rucProveedor) {
        RucProveedor = rucProveedor;
    }

    public String getNombreProveedor() {
        return NombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        NombreProveedor = nombreProveedor;
    }
}
