package Entidades;

public class Empresa {
    private int RUCEmpresa;
    private String NombreEmpresa;
    private boolean disponibilidad;

    public Empresa(int RUCEmpresa, String NombreEmpresa, boolean disponibilidad) {
        this.RUCEmpresa = RUCEmpresa;
        this.NombreEmpresa = NombreEmpresa;
        this.disponibilidad = disponibilidad;
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

    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    
}
