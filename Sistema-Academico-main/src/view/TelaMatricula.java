package view;

import javax.swing.*;
import java.awt.*;

public class TelaMatricula extends JPanel {

    public TelaMatricula() {

        setOpaque(false);

        setLayout(new GridBagLayout());

        JLabel titulo = new JLabel("Matrículas");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);

        add(titulo);

    }

}