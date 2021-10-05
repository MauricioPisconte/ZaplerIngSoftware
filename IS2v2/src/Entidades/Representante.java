package Entidades;

public class Representante {
    private int DNI;
    private String nombre;
    private String apellido;
    private int RUCEmpresa;

    public Representante(int DNI, String nombre, String apellido, int RUCEmpresa) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.RUCEmpresa = RUCEmpresa;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getRUCEmpresa() {
        return RUCEmpresa;
    }

    public void setRUCEmpresa(int RUCEmpresa) {
        this.RUCEmpresa = RUCEmpresa;
    }
}
