package FrontendUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Circle extends JPanel {

    private JFrame fr1;
    private BufferedImage OImage;
    private BufferedImage CImage;

    public Circle() {
        fr1 = new JFrame("Circle");
        this.setBackground(new Color(157, 178, 191));
        fr1.add(this);
        fr1.setSize(1280, 720);
        fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr1.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(7));
        int centerX = (getWidth()) / 2;
        int centerY = (getHeight() + 80) / 2;
        int radius = 200;
        g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
    }

    public static void main(String[] args) {
        new Circle();
    }
}
