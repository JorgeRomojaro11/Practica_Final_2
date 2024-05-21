package Simulacion;

import Celdas.AreaDeCultivo;
import java.util.ArrayList;
import java.util.List;

public class Simulacion {
    private List<AreaDeCultivo> experimentos;

    public Simulacion() {
        this.experimentos = new ArrayList<>();
    }

    public void agregarExperimento(AreaDeCultivo experimento) {
        this.experimentos.add(experimento);
    }

    public void ejecutar() {
        for (AreaDeCultivo experimento : experimentos) {
            experimento.simularDia();
        }
    }
}