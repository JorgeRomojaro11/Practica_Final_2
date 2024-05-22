package Celdas;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Celda {
    private List<Bacteria> bacterias;
    private List<Celda> celdasAdyacentes;
    private Random random;
    private int comida;
    private int x;
    private int y;
    private int width;
    private int height;


    public Celda() {
        this.bacterias = new ArrayList<>();
        this.celdasAdyacentes = new ArrayList<>();
        this.random = new Random();
        this.comida = 0;
    }

    public void agregarBacteria(Bacteria bacteria) {
        this.bacterias.add(bacteria);
    }

    public void removerBacteria(Bacteria bacteria) {
        this.bacterias.remove(bacteria);
    }

    public Celda obtenerCeldaAdyacenteAleatoria() {
        if (celdasAdyacentes.isEmpty()) {
            return null;
        }
        int indice = random.nextInt(celdasAdyacentes.size());
        return celdasAdyacentes.get(indice);
    }

    public void agregarCeldaAdyacente(Celda celda) {
        this.celdasAdyacentes.add(celda);
    }

    public List<Bacteria> getBacterias() {
        return this.bacterias;
    }

    public void agregarComida(int cantidad) {
        this.comida += cantidad;
    }

    public int obtenerComida() {
        int comidaConsumida = this.comida;
        this.comida = 0;
        return comidaConsumida;
    }

    public int getComida() {
        return this.comida;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void actualizarPosicion() {
        x = x + 1;
        y = y + 1;

    }
}