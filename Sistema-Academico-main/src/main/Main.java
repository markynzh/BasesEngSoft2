package main;

import view.JanelaPrincipal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new JanelaPrincipal();

        });

    }

}