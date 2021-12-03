package Entidades;

public class RecibeAtencion {
    private int IdAtencion;
    private int RucEmpresa;
    private int ID_ListaReserva;

    public RecibeAtencion(int IdAtencion, int RucEmpresa, int ID_ListaReserva) {
        this.IdAtencion = IdAtencion;
        this.RucEmpresa = RucEmpresa;
        this.ID_ListaReserva = ID_ListaReserva;
    }

    public RecibeAtencion()
    {
    }
    
    public int getIdAtencion() {
        return IdAtencion;
    }

    public void setIdAtencion(int IdAtencion) {
        this.IdAtencion = IdAtencion;
    }

    public int getRucEmpresa() {
        return RucEmpresa;
    }

    public void setRucEmpresa(int RucEmpresa) {
        this.RucEmpresa = RucEmpresa;
    }

    public int getID_ListaReserva() {
        return ID_ListaReserva;
    }

    public void setID_ListaReserva(int ID_ListaReserva) {
        this.ID_ListaReserva = ID_ListaReserva;
    }

    
}
