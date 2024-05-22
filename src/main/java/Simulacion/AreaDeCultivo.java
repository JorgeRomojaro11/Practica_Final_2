package Simulacion;

import Celdas.Bacteria;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import Celdas.Celda;

public class AreaDeCultivo {
    private List<Bacteria> bacterias;
    private int area;

    public AreaDeCultivo(int area) {
        this.area = area;
        this.bacterias = new ArrayList<>();
    }

    public void inicializar(int cantidadBacterias, int comida) {
        for (int i = 0; i < cantidadBacterias; i++) {
            Celda celda = getCeldaEnPosicion(); // getCelda() is a method that returns a Celda object
            bacterias.add(new Bacteria(celda));
        }
    }

    private Celda getCeldaEnPosicion() {
        // Este método debe devolver una celda en una posición aleatoria del área de cultivo.
        // Como no tenemos información sobre las celdas, devolveremos una nueva celda.
        return new Celda();
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
    public int getColumnas() {
        // Este método debe devolver el número de columnas en el área de cultivo.
        // Como no tenemos información sobre las columnas, devolveremos un valor por defecto.
        return 10;
    }

    public int getFilas() {
        // Este método debe devolver el número de filas en el área de cultivo.
        // Como no tenemos información sobre las filas, devolveremos un valor por defecto.
        return 10;
    }

    public Celda getCeldaEnPosicion(int i, int j) {
        // Este método debe devolver la celda en la posición (i, j).
        // Como no tenemos información sobre las celdas, devolveremos una nueva celda.
        return new Celda();
    }

    public void distribuirComida(int comida) {
        // Este método debe distribuir la comida entre las bacterias.
        // Como no tenemos información sobre cómo se debe distribuir la comida, vamos a alimentar a cada bacteria con la misma cantidad de comida.
        int comidaPorBacteria = comida / bacterias.size();
        for (Bacteria bacteria : bacterias) {
            bacteria.alimentar(comidaPorBacteria);
        }
    }

    public void actualizarCeldas() {
        // Este método debe actualizar el estado de cada celda en el área de cultivo.
        // Como no tenemos información sobre cómo se debe actualizar el estado de las celdas, no haremos nada en este método.
    }

    public void ordenarPoblaciones() {
        // Comparador por fecha de inicio
        Comparator<Bacteria> porFechaDeInicio = new Comparator<Bacteria>() {
            @Override
            public int compare(Bacteria b1, Bacteria b2) {
                return b1.getFechaDeInicio();
            }
        };

        // Comparador por nombre
        Comparator<Bacteria> porNombre = new Comparator<Bacteria>() {
            @Override
            public int compare(Bacteria b1, Bacteria b2) {
                return b1.getNombre().compareTo(b2.getNombre());
            }
        };

        // Comparador por número de bacterias
        Comparator<Bacteria> porNumeroDeBacterias = new Comparator<Bacteria>() {
            @Override
            public int compare(Bacteria b1, Bacteria b2) {
                return Integer.compare(b1.getNumeroDeBacterias(), b2.getNumeroDeBacterias());
            }
        };

        // Ordenar por fecha de inicio
        Collections.sort(bacterias, porFechaDeInicio);

        // Ordenar por nombre
        Collections.sort(bacterias, porNombre);

        // Ordenar por número de bacterias
        Collections.sort(bacterias, porNumeroDeBacterias);
    }

    public List<Celda> getCeldas() {
        // Este método debe devolver una lista con todas las celdas del área de cultivo.
        // Como no tenemos información sobre las celdas, devolveremos una lista vacía.
        return new ArrayList<>();
    }
}