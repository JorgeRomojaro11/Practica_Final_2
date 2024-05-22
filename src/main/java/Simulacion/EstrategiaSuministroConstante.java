package Simulacion;

public class EstrategiaSuministroConstante implements EstrategiaSuministroComida {
    private final int comida;

    public EstrategiaSuministroConstante(int comida) {
        this.comida = comida;
    }

    @Override
    public int calcularComida(int dia) {
        return comida;
    }
}
