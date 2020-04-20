package dev.jsondev;

import javax.swing.*;
import java.util.ArrayList;

public class Empresa {
    protected String nombre;
    private ArrayList<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombre = nombre;
        planilla = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado(Empleado m) {
        this.planilla.add(m);
    }

    public void quitEmpleado(String numero) {
        Empleado empleado = null;
        for (Empleado e : planilla) {
            for (Documento documento : e.getDocumentos()) {
                if (documento.getNumero().equals(numero)) {
                    empleado = e;
                    break;
                }
            }
        }

        if (empleado != null) {
            planilla.remove(empleado);
            JOptionPane.showMessageDialog(null, "Se ha despedido al usuario: " + empleado.getNombre());
        } else
            JOptionPane.showMessageDialog(null, "El usuario no existe!!!!");
    }
}

