package Simulacion;

import Celdas.AreaDeCultivo;

public class Experimento {
    private AreaDeCultivo areaDeCultivo;
    private int dias;

    public Experimento(int tamaño, int cantidadBacterias, int comida, int dias) {
        this.areaDeCultivo = new AreaDeCultivo(tamaño);
        this.areaDeCultivo.inicializar(cantidadBacterias, comida);
        this.dias = dias;
    }

    public void ejecutar() {
        // Implementar la lógica para ejecutar el experimento
    }

    // Otros métodos necesarios
}