package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Vehiculo;
import modelo.cal;
import vista.VistaConsola;

public class Controlador {
    private List<Vehiculo> vehiculos;
    private cal calculadora;
    private VistaConsola vista;
    private int contadorId;

    public Controlador(cal calculadora, VistaConsola vista) {
        this.vehiculos = new ArrayList<>();
        this.calculadora = calculadora;
        this.vista = vista;
        this.contadorId = 1;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    Vehiculo nuevo = vista.registrarVehiculo(contadorId++);
                    vehiculos.add(nuevo);
                    vista.mostrarMensaje("Vehículo registrado con ID: " + nuevo.getId());
                    break;

                case 2:
                    vista.mostrarVehiculos(vehiculos);
                    break;

                case 3:
                    if (vehiculos.isEmpty()) {
                        vista.mostrarMensaje(" Actualmente no hay vehículos registrados para calcular impuestos.");
                    } else {
                        int idBuscado = vista.solicitarIdVehiculo();
                        Vehiculo elegido = buscarVehiculo(idBuscado);

                        if (elegido == null) {
                            vista.mostrarMensaje("No se  han encontrado algun vehículo con ese ID.");
                        } else {
                            vista.mostrarMensaje(" Vehículo seleccionado ");
                            vista.mostrarMensaje(elegido.toString());

                            boolean pronto = vista.preguntar("¿Aplica pronto pago?");
                            boolean publico = vista.preguntar("¿Es de servicio público?");
                            boolean traslado = vista.preguntar("¿Aplica traslado de cuenta?");

                            calculadora.calcularImpuesto(elegido, pronto, publico, traslado);
                        }
                    }
                    break;

                case 4:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private Vehiculo buscarVehiculo(int id) {
        for (Vehiculo v : vehiculos) {
            if (v.getId() == id) return v;
        }
        return null;
    }
}