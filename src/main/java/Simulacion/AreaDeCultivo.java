package Simulacion;

import Celdas.Bacteria;
import java.util.ArrayList;
import java.util.List;
import Celdas.Celda;

public class AreaDeCultivo {
    private List<Bacteria> bacterias;
    private int area;

    public Celda getCelda() {
        return new Celda();
    }

    public AreaDeCultivo(int area) {
        this.area = area;
        this.bacterias = new ArrayList<>();
    }

    public void inicializar(int cantidadBacterias, int comida) {
        for (int i = 0; i < cantidadBacterias; i++) {
            Celda celda = getCelda(); // getCelda() is a method that returns a Celda object
            bacterias.add(new Bacteria(celda));
        }
    }

    public void simularDia() {
        for (Bacteria bacteria : bacterias) {
            bacteria.mover();
            bacteria.comer();
            bacteria.reproducir();
            bacteria.verificarSiMuere();
        }
    }

    public void alimentarBacterias(int comida) {
        int comidaPorBacteria = comida / bacterias.size();
        for (Bacteria bacteria : bacterias) {
            bacteria.alimentar(comidaPorBacteria);
        }
    }
}