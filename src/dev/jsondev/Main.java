package dev.jsondev;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    static ArrayList<Empleado> servicioPorfesional = new ArrayList<>();
    static ArrayList<Empleado> plazaFija = new ArrayList<>();

    public static void main(String[] args) {
        Empresa emp = new Empresa("Facebook");
        String[] menu = { "0. Salir", "1. Agregar Empleado", "2. Despedir empleado", "3. Ver lista de empleados",
                          "4. Calcular sueldo", "5 Mostrar totales"};
        String[] menu1 = {"1. Servicio profesional", "2. Plaza fija"};

        int opc = 0, opc1 = 0;
        do{
            switch (JOptionPane.showOptionDialog(null, "Elige una opcion: ", "Menu: ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, menu, menu[0])) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                case 1:
                        switch (JOptionPane.showOptionDialog(null, "Elige una opcion: ", "Menu: ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, menu1, menu1[0])){
                            case 1:
                                servicioPorfesional.add(addServicioPro());
                                break;
                            case 2:
                                plazaFija.add(addPlazaFija());
                                break;
                            default:
                                break;
                        }

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;


        }
        }while(opc != 0);
    }
    public static Empleado addServicioPro(){
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
        String puesto = JOptionPane.showInputDialog(null, "Ingrese el puesto: ");
        double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario"));
        int mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los meses"));

        return new ServicioProfesional(nombre,puesto,salario,mesesContrato);
    }
    public static Empleado addPlazaFija(){
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
        String puesto = JOptionPane.showInputDialog(null, "Ingrese el puesto: ");
        double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario"));
        int extension = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los meses"));

        return new PlazaFija(nombre,puesto,salario,extension);
    }
}
