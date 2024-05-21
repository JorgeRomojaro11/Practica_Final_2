package Simulacion;

import java.util.ArrayList;
import java.util.List;

public class Simulacion {
    private List<Experimento> experimentos;

    public Simulacion() {
        this.experimentos = new ArrayList<>();
    }

    public void agregarExperimento(Experimento experimento) {
        this.experimentos.add(experimento);
    }

    public void ejecutar() {
        // Implementar la lógica para ejecutar todas las simulaciones
    }

    // Otros métodos necesarios
}