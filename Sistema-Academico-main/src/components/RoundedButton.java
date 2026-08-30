package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton {

    private final Color corNormal = new Color(66, 133, 244);
    private final Color corHover = new Color(100, 181, 246);

    public RoundedButton(String texto) {

        super(texto);

        // Aparência
        setFont(new Font("Segoe UI", Font.BOLD, 17));
        setForeground(Color.WHITE);

        // Tamanho padrão
        setPreferredSize(new Dimension(250, 60));

        // Remove aparência padrão do Swing
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setBackground(corNormal);

        // Efeito Hover
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(corHover);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(corNormal);
                repaint();
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Sombra
        g2.setColor(new Color(0, 0, 0, 50));
        g2.fillRoundRect(4, 4, getWidth() - 4, getHeight() - 4, 35, 35);

        // Botão
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 4, getHeight() - 4, 35, 35);

        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Sem borda
    }
}