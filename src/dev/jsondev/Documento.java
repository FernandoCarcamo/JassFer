package dev.jsondev;

public class Documento {
    private String nombre;
    private int numero;

    public Documento(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() { return nombre; }

    public int getNumero() { return numero; }
}
