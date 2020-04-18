package dev.jsondev;

import java.util.ArrayList;

public class Empresa {
    protected String nombre;
    private ArrayList<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombre = nombre;
        planilla = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    public ArrayList<Empleado> getPlanilla() { return planilla; }

    public void addEmpleado(Empleado m){

    }

    public void quitEmpleado(String m){


    }
}
