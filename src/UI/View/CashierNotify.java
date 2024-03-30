package UI.View;

import javax.swing.*;
import java.awt.*;

public class CashierNotify extends JButton {

    private JFrame mainf;
    private JLabel text;
    private String number = "1";
    private ImageIcon i1, i2;
    
    public CashierNotify() {
        text = new JLabel(number);
        text.setFont(new Font("Aria", Font.BOLD, 2));
        i1 = new ImageIcon("src/UI/Image/mart.png");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(21, 21, Image.SCALE_SMOOTH));
        mainf = new JFrame("Rounded Button Example");
        this.setFont(new Font("Arial", Font.BOLD, 16));
        setContentAreaFilled(false);
        setFocusable(false);
        this.setFont(new Font("Aria", Font.BOLD, 11));
        this.setIcon(i2);
        this.setForeground(new Color(69, 104, 159));
        this.setBackground(Color.WHITE);
        mainf.setBackground(Color.WHITE);
        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainf.setSize(40, 60);
        mainf.add(this);
        mainf.setVisible(false);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D) g.create();
        g1.setStroke(new BasicStroke(2));
        if (getModel().isPressed()) {
            g1.setColor(Color.GRAY.brighter());
        } else {
            g1.setColor(getBackground());
        }
        g1.fillRoundRect(18, 5, 23, 30, 0, 0);
    }

    @Override
    protected void paintBorder(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        Graphics2D g3 = (Graphics2D) g.create();

        //Draw Circle
        g3.setColor(Color.RED);
        g3.fillOval(getWidth() - 23, 0, 14, 14);

        //Draw String
        g3.setColor(Color.WHITE);
        g3.drawString(text.getText(), getWidth() - 18, 11);

        //Draw Rounded Squre
  
        g2.setColor(new Color(69, 104, 159));
        g2.setStroke(new BasicStroke(3));
  
    }
    public static void main(String[] args) {
        new CashierNotify();
        
    }
}
