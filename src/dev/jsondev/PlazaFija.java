package dev.jsondev;

public class PlazaFija extends Empleado {
    private int extension;

    public PlazaFija(String nombre, String puesto, double salario, int extension) {
        super(nombre, puesto, salario);
        this.extension = extension;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        String docs = "";
        for (Documento d : documentos) {
            docs += "||" + d.toString();
        }
        return "*******************" +
                "\nTipo: Plaza Fija" +
                "\nNombre: " + nombre +
                "\nPuesto: " + puesto +
                "\nExtension: " + extension +
                "\nDocumentos: " + docs +
                "\nSalario: " + salario;
    }
}
