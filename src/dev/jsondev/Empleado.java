package dev.jsondev;

import java.util.ArrayList;

public abstract class Empleado {
    protected String nombre, puesto;
    protected ArrayList<Documento> documentos;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        documentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void addDocumento(Documento m) {
        this.documentos.add(m);
    }

    public void removeDocumento(String r) {
        Documento p = null;
        for (Documento w : documentos) {
            if (w.getNumero().equals(r)) {
                p = w;
                break;
            }
        }
        if (p != null) {
            documentos.remove(p);
        }
    }
}



