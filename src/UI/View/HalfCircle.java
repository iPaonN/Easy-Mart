package  View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class HalfCircle extends JPanel {

    private JFrame mainf;
    private ImageIcon i1, i2;
    private Image im1;

    public HalfCircle() {
        mainf = new JFrame("Half Circle with Text Example");
        mainf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(new Color(69, 104, 159));
        this.setOpaque(false);
        mainf.add(this);
        mainf.pack();
        mainf.setVisible(false);
    }

    public Image LoadImage(String link) {
        i1 = new ImageIcon(link);
        im1 = i1.getImage();
        return im1;
    }

    //Overload
    public Image LoadImage(Image im1) {
        i1 = new ImageIcon(im1);
        im1 = i1.getImage();
        return im1;
    }

    @Override
    public void paintComponent(Graphics g) {
        
        //Set Position Draw Circle
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        Graphics2D g3 = (Graphics2D) g.create();
        int position = Math.min(getWidth(), getHeight());
        int x = ((getWidth() - position) / 2);
        int y = ((getHeight() - position) / 2);
        int width = getWidth();
        int height = getHeight();
        
        // Draw Circle
        Ellipse2D c1 = new Ellipse2D.Float(x, y, position, position);
        Ellipse2D c2 = new Ellipse2D.Float(x, y, position, position);
        g2.setClip(c1);
        g3.setClip(c2);
        g2.drawImage(im1, 0, 0, getWidth(), getHeight(), this);
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(8));
        g2.drawOval(x, y, position, position);
        g2.dispose();
       
    }
}
