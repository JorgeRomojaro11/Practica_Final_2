package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Celdas.Bacteria;
import Celdas.Celda;

public class AnimacionExperimento extends JFrame {
    private JPanel panelAnimacion;
    private List<Bacteria> bacterias;
    private List<Celda> celdas;

    public AnimacionExperimento(List<Bacteria> bacterias, List<Celda> celdas) {
        this.bacterias = bacterias;
        this.celdas = celdas;

        setTitle("Animación del Experimento");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panelAnimacion = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Dibujar las celdas
                for (Celda celda : celdas) {
                    g.fillRect(celda.getX(), celda.getY(), celda.getWidth(), celda.getHeight());
                }

                // Dibujar las bacterias
                for (Bacteria bacteria : bacterias) {
                    g.fillOval(bacteria.getX(), bacteria.getY(), bacteria.getWidth(), bacteria.getHeight());
                }
            }
        };

        add(panelAnimacion);
    }

    public void iniciarAnimacion() {
        Timer timer = new Timer(100, e -> {
            // Actualizar la posición de las bacterias y las celdas
            for (Bacteria bacteria : bacterias) {
                bacteria.actualizarPosicion();
            }

            for (Celda celda : celdas) {
                celda.actualizarPosicion();
            }

            // Repintar el panel para mostrar la nueva posición de las bacterias y las celdas
            panelAnimacion.repaint();
        });

        timer.start();
    }
}