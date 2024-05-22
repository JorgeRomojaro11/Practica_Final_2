package Celdas;

import java.util.Random;

public class Bacteria {
    private int comidaConsumida;
    private boolean estaViva;
    private Random random;
    private Celda celdaActual;

    private int x;
    private int y;
    private int width;
    private int height;

    public Bacteria(Celda celdaActual) {
        this.comidaConsumida = 0;
        this.estaViva = true;
        this.random = new Random();
        this.celdaActual = celdaActual;
    }

    public void comer() {
        int comida = celdaActual.obtenerComida();
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
    public Celda getCeldaActual() {
        return this.celdaActual;
    }
    public void consumirComida() {
        // Este método debe hacer que la bacteria consuma comida.
        // Como no tenemos información sobre cuánta comida debe consumir la bacteria, vamos a hacer que consuma una cantidad fija de comida.
        int comida = 10;
        this.comidaConsumida += comida;
    }

    public boolean puedeReproducirse() {
        // Este método debe determinar si la bacteria puede reproducirse.
        // Como no tenemos información sobre cuándo puede reproducirse la bacteria, vamos a hacer que pueda reproducirse si ha consumido al menos 50 unidades de comida.
        return this.comidaConsumida >= 50;
    }

    public Bacteria reproducirse() {
        // Este método debe hacer que la bacteria se reproduzca.
        // Como no tenemos información sobre cómo se reproduce la bacteria, vamos a crear una nueva bacteria en la misma celda y reducir la comida consumida en 50 unidades.
        if (puedeReproducirse()) {
            this.comidaConsumida -= 50;
            return new Bacteria(this.celdaActual);
        }
        return null;
    }

    public void alimentar(int comida) {
        this.comidaConsumida += comida;
    }

    public int getFechaDeInicio() {
        // Este método debe devolver la fecha de inicio de la bacteria.
        // Como no tenemos información sobre la fecha de inicio, devolveremos un valor por defecto.
        return 0;
    }

    public String getNombre() {
        // Este método debe devolver el nombre de la bacteria.
        // Como no tenemos información sobre el nombre, devolveremos un valor por defecto.
        return "Bacteria";
    }

    public int getNumeroDeBacterias() {
        // Este método debe devolver el número de bacterias.
        // Como no tenemos información sobre el número de bacterias, devolveremos un valor por defecto.
        return 0;
    }

    public void actualizarPosicion() {
        x += 1;
        y += 1;
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
}