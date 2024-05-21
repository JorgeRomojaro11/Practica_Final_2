package Interfaz;

import Bacteria.Bacteria;
import Celdas.AreaDeCultivo;
import Celdas.Celda;
import Simulacion.Experimento;
import Simulacion.Simulacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class InterfazExperimento extends JFrame {
    private JButton botonEjecutar;
    private JButton botonGuardar;
    private JButton botonCargar;
    private JTextArea areaTexto;
    private Simulacion simulacion;

    public InterfazExperimento() {
        setTitle("Simulación de Experimento");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        botonEjecutar = new JButton("Ejecutar Experimento");
        botonGuardar = new JButton("Guardar Experimento");
        botonCargar = new JButton("Cargar Experimento");
        areaTexto = new JTextArea();

        // Crear un experimento y agregarlo a la simulación
        AreaDeCultivo areaDeCultivo = new AreaDeCultivo(10);
        areaDeCultivo.inicializar(10, 100);
        Experimento experimento = new Experimento(10, 10, 100, 10);
        simulacion = new Simulacion();
        simulacion.agregarExperimento(experimento);

        botonEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulacion.ejecutar();
                areaTexto.append("Experimento ejecutado.\n");
            }
        });

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOutputStream fileOut = new FileOutputStream("experimento.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(simulacion);
                    out.close();
                    fileOut.close();
                    areaTexto.append("Experimento guardado en experimento.ser\n");
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        });

        botonCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fileIn = new FileInputStream("experimento.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    simulacion = (Simulacion) in.readObject();
                    in.close();
                    fileIn.close();
                    areaTexto.append("Experimento cargado desde experimento.ser\n");
                } catch (IOException i) {
                    i.printStackTrace();
                } catch (ClassNotFoundException c) {
                    System.out.println("Clase Simulacion no encontrada");
                    c.printStackTrace();
                }
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonEjecutar);
        panelBotones.add(botonGuardar);
        panelBotones.add(botonCargar);

        add(panelBotones, BorderLayout.NORTH);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfazExperimento().setVisible(true);
            }
        });
    }
}