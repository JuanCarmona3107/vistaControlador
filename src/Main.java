import controlador.Controlador;
import modelo.cal;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        cal calculadoraImpuestos = new cal(8, 17, 1.7859900);
        VistaConsola vistaConsola = new VistaConsola();
        Controlador controladorPrincipal = new Controlador(calculadoraImpuestos, vistaConsola);

        controladorPrincipal.iniciar();
    }
}
