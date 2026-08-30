package components;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Melhora a qualidade do degradê
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        int width = getWidth();
        int height = getHeight();

        // Cores do degradê
        Color corInicial = new Color(18, 18, 30);
        Color corFinal   = new Color(92, 107, 192);

        GradientPaint gradient = new GradientPaint(
                0, 0, corInicial,
                width, height, corFinal);

        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }
}