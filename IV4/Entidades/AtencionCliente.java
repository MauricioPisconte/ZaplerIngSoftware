package Entidades;

public class AtencionCliente {
    private int IDAtencion;
    private String TiempoInicioAtencion;
    private String Fecha;
    private String Descripcion;
    private int CodVendedor;

    public AtencionCliente(int IDAtencion, String tiempoInicioAtencion, String fecha, String descripcion, int codVendedor) {
        this.IDAtencion = IDAtencion;
        TiempoInicioAtencion = tiempoInicioAtencion;
        Fecha = fecha;
        Descripcion = descripcion;
        CodVendedor = codVendedor;
    }
    
    public AtencionCliente() {
    }

    public int getIDAtencion() {
        return IDAtencion;
    }

    public void setIDAtencion(int IDAtencion) {
        this.IDAtencion = IDAtencion;
    }

    public String getTiempoInicioAtencion() {
        return TiempoInicioAtencion;
    }

    public void setTiempoInicioAtencion(String tiempoInicioAtencion) {
        TiempoInicioAtencion = tiempoInicioAtencion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getCodVendedor() {
        return CodVendedor;
    }

    public void setCodVendedor(int codVendedor) {
        CodVendedor = codVendedor;
    }
}
