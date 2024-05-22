package Interfaz;

import Simulacion.Experimento;
import Simulacion.Simulacion;
import Simulacion.AreaDeCultivo;
import Simulacion.EstrategiaSuministroConstante;
import Celdas.Celda;
import Celdas.Bacteria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.List;

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

        botonEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Solicitar al usuario que introduzca las estadísticas
                String area = JOptionPane.showInputDialog("Introduce el área de cultivo:");
                String inicializarArea = JOptionPane.showInputDialog("Introduce el área a inicializar:");
                String inicializarCantidad = JOptionPane.showInputDialog("Introduce la cantidad a inicializar:");
                String duracion = JOptionPane.showInputDialog("Introduce la duración del experimento:");
                String repeticiones = JOptionPane.showInputDialog("Introduce el número de repeticiones:");

                // Crear un experimento y agregarlo a la simulación
                AreaDeCultivo areaDeCultivo = new AreaDeCultivo(Integer.parseInt(area));
                areaDeCultivo.inicializar(Integer.parseInt(inicializarArea), Integer.parseInt(inicializarCantidad));
                Experimento experimento = new Experimento("Experimento 1", LocalDate.now(), Integer.parseInt(duracion), Integer.parseInt(repeticiones), areaDeCultivo, new EstrategiaSuministroConstante(100));
                simulacion = new Simulacion();
                simulacion.agregarExperimento(experimento);

                simulacion.ejecutar();
                areaTexto.append("Experimento ejecutado.\n");

                List<Bacteria> bacterias = experimento.getBacterias();
                List<Celda> celdas = experimento.getCeldas();

                // Crear la animación con las bacterias y las celdas del experimento
                AnimacionExperimento animacion = new AnimacionExperimento(bacterias, celdas);

                // Hacer visible la animación y comenzarla
                animacion.setVisible(true);
                animacion.iniciarAnimacion();
            }
        });

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showSaveDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        FileOutputStream fileOut = new FileOutputStream(file);
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(simulacion);
                        out.close();
                        fileOut.close();
                        areaTexto.append("Experimento guardado en " + file.getAbsolutePath() + "\n");
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                }
            }
        });

        botonCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        FileInputStream fileIn = new FileInputStream(file);
                        ObjectInputStream in = new ObjectInputStream(fileIn);
                        simulacion = (Simulacion) in.readObject();
                        in.close();
                        fileIn.close();
                        areaTexto.append("Experimento cargado desde " + file.getAbsolutePath() + "\n");
                    } catch (IOException i) {
                        i.printStackTrace();
                    } catch (ClassNotFoundException c) {
                        System.out.println("Clase Simulacion no encontrada");
                        c.printStackTrace();
                    }
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
            @Override
            public void run() {
                new InterfazExperimento().setVisible(true);
            }
        });
    }
}
