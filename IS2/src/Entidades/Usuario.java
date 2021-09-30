package Entidades;

public class Usuario {
    private int Codigo;
    private String Pass;
    private String nombre;
    private String apellido;

    public Usuario(int codigo, String pass, String nombre, String apellido) {
        Codigo = codigo;
        Pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
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
}
