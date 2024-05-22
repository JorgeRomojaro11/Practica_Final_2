package Simulacion;

import Celdas.Bacteria;
import Celdas.Celda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulacion {
    private List<Bacteria> bacterias;
    private Random random;
    private List<Experimento> experimentos;

    public Simulacion() {
        this.bacterias = new ArrayList<>();
        this.random = new Random();
        this.experimentos = new ArrayList<>();
    }

    public void agregarExperimento(Experimento experimento) {
        experimentos.add(experimento);
    }

    public void inicializar(int cantidadBacterias, int comida) {
        Celda celdaInicial = new Celda(); // Create an initial cell
        for (int i = 0; i < cantidadBacterias; i++) {
            Celda celda = new Celda(); // Create a new cell
            celda.agregarCeldaAdyacente(celdaInicial); // Add the initial cell as an adjacent cell
            celda.agregarComida(comida); // Add food to the cell
            bacterias.add(new Bacteria(celda)); // Pass the cell to the Bacteria constructor
        }
    }

    public void simularDia() {
        for (Bacteria bacteria : bacterias) {
            if (bacteria.estaViva()) {
                bacteria.mover();
                bacteria.comer();
                bacteria.reproducir();
                bacteria.verificarSiMuere();
            }
        }
    }

    public void alimentarBacterias(int comida) {
        for (Bacteria bacteria : bacterias) {
            Celda celda = bacteria.getCeldaActual(); // Get the current cell of the bacteria
            celda.agregarComida(comida); // Add food to the cell
            bacteria.alimentar(comida); // Feed the bacteria
        }
    }

    public void ejecutar() {
        for (Experimento experimento : experimentos) {
            int dias = experimento.getDuracion();
            int comidaPorDia = experimento.getComidaPorDia();
            inicializar(bacterias.size(), comidaPorDia);
            for (int i = 0; i < dias; i++) {
                simularDia();
                alimentarBacterias(comidaPorDia);
            }
        }
    }
}