package modelo;

public class Vehiculo {
    private int id;
    private String marca;
    private String linea;
    private int modelo;
    private long valorComercial;

    public Vehiculo(int id, String marca, String linea, int modelo, long valorComercial) {
        this.id = id;

        // Normalizar cadenas (eliminar espacios y poner en mayúsculas)
        this.marca = (marca != null) ? marca.trim().toUpperCase() : "DESCONOCIDA";
        this.linea = (linea != null) ? linea.trim().toUpperCase() : "DESCONOCIDA";

        // Normalizar año (mínimo 1900, máximo año actual)
        int anioActual = java.time.Year.now().getValue();
        if (modelo < 1900 || modelo > anioActual) {
            this.modelo = anioActual; // si es inválido, se coloca el año actual
        } else {
            this.modelo = modelo;
        }

        // Normalizar valor (no puede ser negativo)
        this.valorComercial = Math.max(0, valorComercial);
    }

    public int getId() { return id; }
    public String getMarca() { return marca; }
    public String getLinea() { return linea; }
    public int getModelo() { return modelo; }
    public double getValorComercial() { return valorComercial; }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Marca: " + marca +
                " | Línea: " + linea +
                " | Modelo: " + modelo +
                " | Valor: $" + valorComercial;
    }
}
