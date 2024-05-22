package org.example;

import Interfaz.InterfazExperimento;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                InterfazExperimento interfaz = new InterfazExperimento();
                interfaz.setVisible(true);
            }
        });
    }
}