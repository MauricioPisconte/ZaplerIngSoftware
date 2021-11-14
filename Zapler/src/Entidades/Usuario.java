package Entidades;

public class Usuario {
    private int Codigo;
    private String Pass;
    private String nombre;
    private String apellido;
    private String rol;
    private boolean disponibilidad;

    public Usuario(int Codigo, String Pass, String nombre, String apellido, String rol, boolean disponibilidad) {
        this.Codigo = Codigo;
        this.Pass = Pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.disponibilidad = disponibilidad;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
}
