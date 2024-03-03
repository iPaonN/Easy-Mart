package UI;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Circle extends JPanel {

    private JFrame fr1;
    private ImageIcon i1, i2;
    private Image im1;

    public Circle() {

        // Set Image
        i1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        im1 = i1.getImage();

        //Set JFrame
        fr1 = new JFrame("Circle");
        this.setBackground(new Color(101, 113, 132));
        fr1.add(this);
        fr1.setSize(i1.getIconWidth(), i1.getIconHeight());
        fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr1.setVisible(false);

    }

    @Override
    public void paintComponent(Graphics g) {

        //Set Position Draw Circle
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        int position = Math.min(getWidth(), getHeight());
        int x = ((getWidth() - position) / 2);
        int y = ((getHeight() - position) / 2);
        
        // Draw Circle
        Ellipse2D c1 = new Ellipse2D.Float(x, y, position, position);
        g2.setClip(c1);
        g2.drawImage(im1, 0, 0, getWidth(), getHeight(), this);
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(15));
        g2.drawOval(x, y, position, position);
        g2.dispose();
        
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.paint(null);
    }
}
