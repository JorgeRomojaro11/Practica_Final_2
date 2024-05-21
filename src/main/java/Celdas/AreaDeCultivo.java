package Celdas;

import Bacteria.Bacteria;

import java.util.Random;

public class AreaDeCultivo {
    private Celda[][] celdas;
    private Random random;

    public AreaDeCultivo(int tamaño) {
        this.celdas = new Celda[tamaño][tamaño];
        this.random = new Random();
        // Inicializar las celdas
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }

    public void inicializar(int cantidadBacterias, int comida) {
        // Distribuir bacterias y comida de manera aleatoria
        for (int i = 0; i < cantidadBacterias; i++) {
            int x = random.nextInt(celdas.length);
            int y = random.nextInt(celdas[0].length);
            celdas[x][y].agregarBacteria(new Bacteria(celdas[x][y]));
        }
        for (int i = 0; i < comida; i++) {
            int x = random.nextInt(celdas.length);
            int y = random.nextInt(celdas[0].length);
            celdas[x][y].agregarComida(1);
        }
    }

    public void simularDia() {
        // Hacer que cada bacteria en cada celda se mueva, coma, se reproduzca y verifique si muere
        for (Celda[] fila : celdas) {
            for (Celda celda : fila) {
                for (Bacteria bacteria : celda.getBacterias()) {
                    bacteria.mover();
                    bacteria.comer(celda.obtenerComida());
                    bacteria.reproducir();
                    bacteria.verificarSiMuere();
                }
            }
        }
    }
}
