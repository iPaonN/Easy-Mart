package UI.View;

import javax.swing.*;
import java.awt.*;

public class RoundedButton2 extends JButton {

    private JFrame mainf;
    private String number = "1";

    public RoundedButton2() {
        mainf = new JFrame("Rounded Button Example");
        this.setFont(new Font("Arial", Font.BOLD, 16));
        setContentAreaFilled(false);
        setFocusable(false);
        this.setText("VIEW");
        this.setForeground(new Color(69, 104, 159));
        this.setBackground(Color.WHITE);
        mainf.setBackground(Color.WHITE);
        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainf.setSize(200, 120);
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
            g1.setColor(Color.GRAY);
        } else {
            g1.setColor(getBackground());
        }
        g1.fillRoundRect(20, 18, getWidth() - 40, getHeight() / 2, 0, 0);
    }

    @Override
    protected void paintBorder(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        Graphics2D g3 = (Graphics2D) g.create();

        //Draw Circle
        g3.setColor(Color.RED);
        g3.fillOval(getWidth() - 26, 3, 23, 23);

        //Draw String
        g3.setColor(Color.WHITE);
        g3.drawString(number, getWidth() - 19, 20);

        //Draw Rounded Squre
        g2.setColor(new Color(69, 104, 159));
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(20, 18, getWidth() - 40, getHeight() / 2, 0, 0);
    }
}
