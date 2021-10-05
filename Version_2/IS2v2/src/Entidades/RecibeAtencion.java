package Entidades;

public class RecibeAtencion {
    private int IdAtencion;
    private int RucEmpresa;

    public RecibeAtencion(int idAtencion, int rucEmpresa) {
        IdAtencion = idAtencion;
        RucEmpresa = rucEmpresa;
    }

    public int getIdAtencion() {
        return IdAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        IdAtencion = idAtencion;
    }

    public int getRucEmpresa() {
        return RucEmpresa;
    }

    public void setRucEmpresa(int rucEmpresa) {
        RucEmpresa = rucEmpresa;
    }
}
