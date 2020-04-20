package dev.jsondev;

public class CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private CalculadoraImpuestos() {
    }

    public static double calcularPago(Empleado m) {
        double restante, pago;
        if (m instanceof PlazaFija) {
            totalAFP = m.getSalario() * 0.0625;
            totalISSS = m.getSalario() * 0.03;
            restante = m.getSalario() - totalAFP - totalISSS;

            if (restante <= 472) {
                totalRenta = 0;
            } else if (restante <= 895.24) {
                totalRenta = (0.1 * (restante - 472)) + 17.67;
            } else if (restante <= 2038.1) {
                totalRenta = (0.2 * (restante - 895.24)) + 60;
            } else {
                totalRenta = (0.3 * (restante - 2038.1)) + 288.57;
            }
            pago = restante - totalRenta;
        } else {
            totalRenta = m.getSalario() * 0.1;
            pago = m.getSalario() - totalRenta;
        }
        return pago;
    }

    public static String mostrarTotales(Empleado empleado) {
        double pago = calcularPago(empleado);
        return "CalculadoraImpuestos{" +
                "totalRenta=" + totalRenta +
                ", totalISSS=" + totalISSS +
                ", totalAFP=" + totalAFP +
                ", Pago=" + pago +
                '}';
    }
}
