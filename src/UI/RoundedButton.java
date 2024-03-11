package UI;
import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    private JFrame mainf;
    public RoundedButton() {
        mainf = new JFrame("Rounded Button Example");
        this.setText("Cilck me");
        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainf.setSize(200, 100);
        mainf.add(this);
        mainf.setVisible(true);
        setContentAreaFilled(false);
        setFocusable(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(Color.GRAY);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); 
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
    }

    public static void main(String[] args) {
        new RoundedButton();
    }
}

