package Simulacion;

import Celdas.Bacteria;
import Celdas.Celda;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Experimento {
    private String nombre;
    private LocalDate fechaInicio;
    private int duracionDias;
    private int comidaMicrogramos;
    private AreaDeCultivo areaDeCultivo;
    private EstrategiaSuministroComida patronAlimentacion;
    private List<Bacteria> bacterias;
    private int diaActual = 0;
    private ArrayList<int[][][]> resultados;

    public Experimento(String nombre, LocalDate fechaInicio, int duracionDias, int comidaMicrogramos, AreaDeCultivo areaDeCultivo, EstrategiaSuministroComida patronAlimentacion) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.duracionDias = duracionDias;
        this.comidaMicrogramos = comidaMicrogramos;
        this.areaDeCultivo = areaDeCultivo;
        this.patronAlimentacion = patronAlimentacion;
        this.resultados = new ArrayList<>();
    }

    public void ejecutar() {
        for (int dia = 0; dia < duracionDias; dia++) {
            simularDia();

            int[][][] estado = obtenerEstadoPlato();
            resultados.add(estado);
        }
    }

    private int[][][] obtenerEstadoPlato() {
        int[][][] estado = new int[areaDeCultivo.getFilas()][areaDeCultivo.getColumnas()][2];
        for (int i = 0; i < areaDeCultivo.getFilas(); i++) {
            for (int j = 0; j < areaDeCultivo.getColumnas(); j++) {
                estado[i][j][0] = areaDeCultivo.getCeldaEnPosicion(i, j).getBacterias().size();
                estado[i][j][1] = areaDeCultivo.getCeldaEnPosicion(i, j).getComida();
            }
        }
        return estado;
    }

    public void mostrarResultados() {
        for (int dia = 0; dia < resultados.size(); dia++) {
            System.out.println("Día " + dia + ":");
            for (int fila = 0; fila < areaDeCultivo.getFilas(); fila++) {
                for (int columna = 0; columna < areaDeCultivo.getColumnas(); columna++) {
                    int numeroBacterias = resultados.get(dia)[fila][columna][0];
                    int comidaRestante = resultados.get(dia)[fila][columna][1];
                    System.out.println("Celda [" + fila + "][" + columna + "]: " + numeroBacterias + " bacterias, " + comidaRestante + " comida restante");
                }
            }
        }
    }



    public int getDuracion() {
        return duracionDias;
    }

    public int getComidaPorDia() {
        return patronAlimentacion.calcularComida(diaActual);
    }

    public int calcularComidaParaElDia() {
        return patronAlimentacion.calcularComida(diaActual++);
    }

    public void simularDia() {
        // Distribuir la comida a las bacterias
        int comidaParaElDia = calcularComidaParaElDia();
        areaDeCultivo.distribuirComida(comidaParaElDia);

        // Permitir que cada bacteria consuma comida y se reproduzca si es posible
        for (Bacteria bacteria : bacterias) {
            bacteria.consumirComida();
            if (bacteria.puedeReproducirse()) {
                bacterias.add(bacteria.reproducirse());
            }
        }

        // Actualizar el estado de cada celda en el área de cultivo
        areaDeCultivo.actualizarCeldas();

        // Incrementar el día actual
        diaActual++;
    }

    public List<Bacteria> getBacterias() {
        return bacterias;
    }

    public List<Celda> getCeldas() {
        return areaDeCultivo.getCeldas();
    }
}