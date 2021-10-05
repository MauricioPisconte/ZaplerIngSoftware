package Entidades;

public class Empresa {
    private int RUCEmpresa;
    private String NombreEmpresa;

    public Empresa(int RUCEmpresa, String nombreEmpresa) {
        this.RUCEmpresa = RUCEmpresa;
        NombreEmpresa = nombreEmpresa;
    }

    public int getRUCEmpresa() {
        return RUCEmpresa;
    }

    public void setRUCEmpresa(int RUCEmpresa) {
        this.RUCEmpresa = RUCEmpresa;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        NombreEmpresa = nombreEmpresa;
    }
}
