package UI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RoundRectangle extends JPanel{
   private JFrame main;
   public RoundRectangle() {
      main = new JFrame("RoundedRectangle Test");
      this.setBackground(Color.WHITE);
      main.add(this);
      main.setSize(1280, 720);
      main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      main.setLocationRelativeTo(null);
      main.setVisible(true);
   }
   @Override
   public void paint(Graphics g) {
      Graphics2D g2d = (Graphics2D) g;
      Graphics2D g1d = (Graphics2D) g;
      g2d.setColor(Color.RED);
      g2d.setStroke(new BasicStroke(10));
      g1d.fillArc(100, 100, 300, 300, 0, -180);
      g2d.drawRoundRect(40, 70, 1200, 500, 100, 100); // to draw a rounded rectangle.
   }
   public static void main(String []args) {
      new RoundRectangle();
   }
}
