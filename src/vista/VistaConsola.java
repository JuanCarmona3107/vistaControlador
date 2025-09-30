package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Vehiculo;

public class VistaConsola {
    private Scanner lectorEntrada;

    public VistaConsola() {
        lectorEntrada = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n=== MENÚ IMPUESTO VEHICULAR ===");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Listar vehículos registrados");
        System.out.println("3. Consultar impuesto de un vehículo");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
        return lectorEntrada.nextInt();
    }

    public Vehiculo registrarVehiculo(int identificadorVehiculo) {
        lectorEntrada.nextLine(); // limpiar buffer

        System.out.print("Ingrese la marca del vehículo: ");
        String marcaVehiculo = lectorEntrada.nextLine().trim().toUpperCase();

        System.out.print("Ingrese la línea del vehículo: ");
        String lineaVehiculo = lectorEntrada.nextLine().trim().toUpperCase();

        System.out.print("Ingrese el modelo del vehículo (año): ");
        int anioModeloVehiculo = lectorEntrada.nextInt();

        System.out.print("Ingrese el valor comercial del vehículo: ");
        long valorComercialVehiculo = lectorEntrada.nextLong();

        return new Vehiculo(identificadorVehiculo, marcaVehiculo, lineaVehiculo, anioModeloVehiculo, valorComercialVehiculo);
    }

    public void mostrarVehiculos(List<Vehiculo> listaVehiculos) {
        if (listaVehiculos.isEmpty()) {
            System.out.println("\n⚠️ No hay vehículos registrados.");
        } else {
            System.out.println("\n--- Vehículos registrados ---");
            for (Vehiculo vehiculoActual : listaVehiculos) {
                System.out.println(vehiculoActual);
            }
        }
    }

    public int solicitarIdVehiculo() {
        System.out.print("Ingrese la identificación del vehículo: ");
        return lectorEntrada.nextInt();
    }

    public boolean preguntar(String textoPregunta) {
        System.out.print(textoPregunta + " (si/no): ");
        return lectorEntrada.next().equalsIgnoreCase("si");
    }

    public void mostrarMensaje(String textoMensaje) {
        System.out.println(textoMensaje);
    }
}
