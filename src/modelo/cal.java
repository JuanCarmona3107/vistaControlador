package modelo;

public class cal{
    private double descProntoPago;
    private double descTrasladoCuenta;
    private double descServicioPublico;

    public cal(double prontoPago, double trasladoCuenta, double servicioPublico) {
        this.descProntoPago = prontoPago;
        this.descTrasladoCuenta = trasladoCuenta;
        this.descServicioPublico = servicioPublico;
    }

    public double calcularImpuesto(Vehiculo v, boolean prontoPago, boolean servicioPublico, boolean traslado) {
        long total = (long) v.getValorComercial();
        System.out.println("\n Detalle del cálculo ");
        System.out.println("Valor base del vehículo: $" + total);

        if (prontoPago) {
            double d1 = total * descProntoPago / 100;
            total -= d1;
            System.out.println("Descuento pronto pago: -$" + d1);
        }

        if (servicioPublico) {
            total -= descServicioPublico;
            System.out.println("Descuento servicio público: -$" + descServicioPublico);
        }

        if (traslado) {
            double d3 = total * descTrasladoCuenta / 100;
            total -= d3;
            System.out.println("Descuento traslado de cuenta: -$" + d3);
        }

        System.out.println("Total a pagar: $" + total);
        return total;


    }
}