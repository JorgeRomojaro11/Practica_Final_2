package Bacteria;

import java.util.Random;
import Celdas.Celda;

public class Bacteria {
    private int comidaConsumida;
    private boolean estaViva;
    private Random random;
    private Celda celdaActual;

    public Bacteria(Celda celdaActual) {
        this.comidaConsumida = 0;
        this.estaViva = true;
        this.random = new Random();
        this.celdaActual = celdaActual;
    }

    public void comer(int comida) {
        this.comidaConsumida += comida;
    }

    public void mover() {
        Celda nuevaCelda = celdaActual.obtenerCeldaAdyacenteAleatoria();
        if (nuevaCelda != null) {
            celdaActual.removerBacteria(this);
            nuevaCelda.agregarBacteria(this);
            celdaActual = nuevaCelda;
        }
    }

    public void reproducir() {
        if (comidaConsumida >= 50) {
            Celda celdaParaReproduccion = celdaActual.obtenerCeldaAdyacenteAleatoria();
            if (celdaParaReproduccion != null) {
                Bacteria nuevaBacteria = new Bacteria(celdaParaReproduccion);
                celdaParaReproduccion.agregarBacteria(nuevaBacteria);
                comidaConsumida -= 50;
            }
        }
    }

    public void verificarSiMuere() {
        int numeroAleatorio = random.nextInt(100);
        if (comidaConsumida >= 100 && numeroAleatorio < 3) {
            this.estaViva = false;
        } else if (comidaConsumida < 100 && comidaConsumida > 9 && numeroAleatorio < 6) {
            this.estaViva = false;
        } else if (comidaConsumida <= 9 && numeroAleatorio < 20) {
            this.estaViva = false;
        }
    }

    public boolean estaViva() {
        return this.estaViva;
    }
}