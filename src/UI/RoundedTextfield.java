package UI;
import javax.swing.*;
import java.awt.*;

public class RoundedTextfield extends JTextField {

    public RoundedTextfield(int columns) {
        super(columns);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(10)); // กำหนดความหนาของเส้น
        g2d.setColor(Color.BLACK); // กำหนดสีของเส้น
        g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1); // วาดเส้นกรอบ
    }

    // ตัวอย่างการใช้งาน
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom TextField Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        // สร้าง JTextField ที่ปรับรูปทรงแล้ว
        JTextField customTextField = new RoundedTextfield(20);
        frame.add(customTextField);

        frame.setVisible(true);
    }
}
