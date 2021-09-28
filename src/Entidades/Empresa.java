package Entidades;

public class Empresa {
    private int RucEmpresa;
    private String NombreEmpresa;

    public Empresa(int rucEmpresa, String nombreEmpresa) {
        RucEmpresa = rucEmpresa;
        NombreEmpresa = nombreEmpresa;
    }

    public int getRucEmpresa() {
        return RucEmpresa;
    }

    public void setRucEmpresa(int rucEmpresa) {
        RucEmpresa = rucEmpresa;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        NombreEmpresa = nombreEmpresa;
    }
}
