package Simulacion;

import Celdas.AreaDeCultivo;

public class Experimento {
    private AreaDeCultivo areaDeCultivo;

    public Experimento(int duracion, int cantidadBacterias, int comida, int tamañoAreaDeCultivo) {
        this.areaDeCultivo = new AreaDeCultivo(tamañoAreaDeCultivo);
        this.areaDeCultivo.inicializar(cantidadBacterias, comida);
    }

    public AreaDeCultivo getAreaDeCultivo() {
        return this.areaDeCultivo;
    }
}