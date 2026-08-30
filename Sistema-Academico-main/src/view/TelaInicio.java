package view;

import javax.swing.*;
import java.awt.*;

public class TelaInicio extends JPanel {

    public TelaInicio() {

        setOpaque(false);

        setLayout(new GridBagLayout());

        JPanel painel = new JPanel();
        painel.setOpaque(false);
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Bem-vindo!");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 34));
        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("Sistema de Gerenciamento Estudantil");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        painel.add(titulo);
        painel.add(Box.createVerticalStrut(15));
        painel.add(subtitulo);

        add(painel);
    }
}