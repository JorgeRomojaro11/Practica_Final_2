package Simulacion;

import Celdas.Bacteria;

import java.time.LocalDate;
import java.util.List;

public class Experimento {
    private String nombre;
    private LocalDate fechaInicio;
    private int duracionDias;
    private int comidaMicrogramos;
    private AreaDeCultivo areaDeCultivo;
    private EstrategiaSuministroComida patronAlimentacion;
    private List<Bacteria> bacterias;
    private int diaActual = 0;

    public Experimento(String nombre, LocalDate fechaInicio, int duracionDias, int comidaMicrogramos, AreaDeCultivo areaDeCultivo, EstrategiaSuministroComida patronAlimentacion) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.duracionDias = duracionDias;
        this.comidaMicrogramos = comidaMicrogramos;
        this.areaDeCultivo = areaDeCultivo;
        this.patronAlimentacion = patronAlimentacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getDuracion() {
        return duracionDias;
    }

    public int getComidaPorDia() {
        return patronAlimentacion.calcularComida(diaActual);
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public int getComidaMicrogramos() {
        return comidaMicrogramos;
    }

    public void setComidaMicrogramos(int comidaMicrogramos) {
        this.comidaMicrogramos = comidaMicrogramos;
    }

    public AreaDeCultivo getAreaDeCultivo() {
        return areaDeCultivo;
    }

    public void setAreaDeCultivo(AreaDeCultivo areaDeCultivo) {
        this.areaDeCultivo = areaDeCultivo;
    }

    public EstrategiaSuministroComida getPatronAlimentacion() {
        return patronAlimentacion;
    }

    public void setPatronAlimentacion(EstrategiaSuministroComida patronAlimentacion) {
        this.patronAlimentacion = patronAlimentacion;
    }

    public List<Bacteria> getBacterias() {
        return bacterias;
    }

    public void setBacterias(List<Bacteria> bacterias) {
        this.bacterias = bacterias;
    }

    public int getDiaActual() {
        return diaActual;
    }

    public void setDiaActual(int diaActual) {
        this.diaActual = diaActual;
    }

    public int calcularComidaParaElDia() {
        return patronAlimentacion.calcularComida(diaActual++);
    }
}