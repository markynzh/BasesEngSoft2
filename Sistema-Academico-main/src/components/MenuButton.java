package components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuButton extends JButton {

    private final Color corNormal = new Color(25, 25, 35);
    private final Color corHover = new Color(38, 38, 55);

    public MenuButton(String texto) {
        super(texto);

        setFont(new Font("Segoe UI", Font.PLAIN, 17));
        setForeground(Color.WHITE);

        setHorizontalAlignment(SwingConstants.LEFT);
        setBorder(new EmptyBorder(0, 20, 0, 0));

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Define um tamanho padrão para todos os botões
        setPreferredSize(new Dimension(220, 48));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 48));
        setMinimumSize(new Dimension(220, 48));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getModel().isRollover() ? corHover : corNormal);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.dispose();

        super.paintComponent(g);
    }
}