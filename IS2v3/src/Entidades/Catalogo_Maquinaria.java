package Entidades;

public class Catalogo_Maquinaria {
    private int IdMaquinaria;
    private String Tipo;
    private int costo;
    private String Marca;
    private String Modelo;

    public Catalogo_Maquinaria(int idMaquinaria, String tipo, int costo, String marca, String modelo) {
        IdMaquinaria = idMaquinaria;
        Tipo = tipo;
        this.costo = costo;
        Marca = marca;
        Modelo = modelo;
    }

    public int getIdMaquinaria() {
        return IdMaquinaria;
    }

    public void setIdMaquinaria(int idMaquinaria) {
        IdMaquinaria = idMaquinaria;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }
}
