package dev.jsondev;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    static ArrayList<Empleado> empleados = new ArrayList<>();
    static Empresa emp = new Empresa("Facebook");

    public static void main(String[] args) throws NotExistingEmployeeException {

        String[] menu = {"0. Salir", "1. Agregar Empleado", "2. Despedir empleado", "3. Ver lista de empleados",
                "4. Calcular sueldo", "5 Mostrar totales"};
        String[] menu1 = {"1. Servicio profesional", "2. Plaza fija"};

        boolean continuar = true;
        do {
            switch (JOptionPane.showOptionDialog(null, "Elige una opcion: ", "Menu: ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, menu, menu[0])) {
                case 0:
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                case 1:
                    //Agregar Empleado
                    switch (JOptionPane.showOptionDialog(null, "Elige una opcion: ", "Menu: ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, menu1, menu1[0])) {
                        case 0:
                            empleados.add(addServicioPro());
                            break;
                        case 1:
                            empleados.add(addPlazaFija());
                            break;
                        default:
                            break;
                    }

                    break;
                case 2:
                    //Despedir Empleado
                    despedir();
                    break;
                case 3:
                    //Listado de empleados
                    listaEmpleados();
                    break;
                case 4:
                    calcularSueldo();
                    //Calculas sueldo
                    break;
                case 5:
                    mostrarTotales();
                    //Mostrar Totales
                    break;
                default:
                    break;
            }
        } while (continuar);
    }

    public static void listaEmpleados(){
        String[] menu = {"1. Servicio profesional", "2. Plaza fija"};
        switch (JOptionPane.showOptionDialog(null, "Elige una opcion: ", "Menu: ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, menu, menu[0])) {
            case 0:
                for(Empleado s: empleados){
                    if(s instanceof ServicioProfesional){
                        JOptionPane.showMessageDialog(null, s.toString() + "\n");
                    }
                }
                break;
            case 1:
                for(Empleado e: empleados){
                    if(e instanceof PlazaFija){
                        JOptionPane.showMessageDialog(null, e.toString() + "\n");
                    }
                }
                break;
        }

    }

    public static void despedir() {
        String numero = JOptionPane.showInputDialog(null, "Ingrese el DUI o NIT Sin espacios del empleado que desea despedir");
        emp.quitEmpleado(numero);

    }

    public static void mostrarTotales() {
        String listado = "";
        for (Empleado e : empleados) {
            listado += CalculadoraImpuestos.mostrarTotales(e) + "\n";
        }
        JOptionPane.showMessageDialog(null, listado);
    }

    public static void calcularSueldo() {
        String doc = JOptionPane.showInputDialog(null, "Ingrese el DUI o NIT Sin espacios: ");
        Empleado empleado = null;
        for (Empleado e : empleados) {
            for (Documento documento : e.getDocumentos()) {
                if (documento.getNumero().equals(doc)) {
                    empleado = e;
                    break;
                }
            }
        }

        if (empleado == null) {
            JOptionPane.showMessageDialog(null, "No se encontro el empleado");
            return;
        }

        JOptionPane.showMessageDialog(null, "El salario para: " + empleado.getNombre() + " es de: " + CalculadoraImpuestos.calcularPago(empleado));
    }

    public static Empleado addServicioPro() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
        String puesto = JOptionPane.showInputDialog(null, "Ingrese el puesto: ");
        double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario"));
        int mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los meses"));
        ServicioProfesional s = new ServicioProfesional(nombre, puesto, salario, mesesContrato);
        s.documentos = addDocs();
        return s;
    }

    public static Empleado addPlazaFija() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
        String puesto = JOptionPane.showInputDialog(null, "Ingrese el puesto: ");
        double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario"));
        int extension = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la extension"));
        PlazaFija p = new PlazaFija(nombre, puesto, salario, extension);
        p.documentos = addDocs();
        return p;

    }

    public static ArrayList<Documento> addDocs() {
        boolean f = false;
        String dui = "", nit = "";
        ArrayList<Documento> docs = new ArrayList<>();
        do {
            dui = JOptionPane.showInputDialog(null, "Ingrese el DUI sin guiones ni espacios:");
            for (Empleado e : empleados) {
                for (Documento doc : e.getDocumentos()) {
                    if (doc.getNombre().equals("DUI") && doc.getNumero().equals(dui)) {
                        JOptionPane.showMessageDialog(null, "DUI Ya establecido");
                        f = true;
                        break;
                    }
                }
            }
            if (!f) {
                docs.add(new Documento("DUI", dui));
            }
        } while (f);
        f = false;
        do {
            nit = JOptionPane.showInputDialog(null, "Ingrese el NIT sin guiones ni espacios:");
            if (nit == dui) {
                JOptionPane.showMessageDialog(null, "NIT No puede ser igual que el DUI");
                f = true;
            }
            for (Empleado e : empleados) {
                for (Documento doc : e.getDocumentos()) {
                    if (doc.getNombre().equals("NIT") && doc.getNumero().equals(nit)) {
                        JOptionPane.showMessageDialog(null, "NIT Ya establecido");
                        f = true;
                        break;
                    }
                }
            }
            if (!f) {
                docs.add(new Documento("NIT", nit));
            }
        } while (f);
        return docs;
    }
}
