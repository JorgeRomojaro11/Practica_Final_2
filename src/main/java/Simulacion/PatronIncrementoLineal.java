package Simulacion;

public class PatronIncrementoLineal implements PatronAlimentacion, EstrategiaSuministroComida {
    private int comidaInicial;
    private int comidaFinal;
    private int duracionDias;

    public PatronIncrementoLineal(int comidaInicial, int comidaFinal, int duracionDias) {
        if (duracionDias <= 0) {
            throw new IllegalArgumentException("La duración en días debe ser mayor que cero");
        }
        this.comidaInicial = comidaInicial;
        this.comidaFinal = comidaFinal;
        this.duracionDias = duracionDias;
    }

    @Override
    public int calcularComida(int dia) {
        if (dia < 0 || dia > duracionDias) {
            throw new IllegalArgumentException("El día proporcionado debe estar entre 0 y " + duracionDias);
        }
        if (duracionDias == 1) {
            return comidaInicial;
        }
        double incrementoDiario = (double) (comidaFinal - comidaInicial) / (duracionDias - 1);
        return comidaInicial + (int) Math.round(incrementoDiario * dia);
    }
}
