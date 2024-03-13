package UI.View;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class DeleteNotify {

    private JFrame fr;
    private JLabel label, label2;
    private JButton bn1;
    private JPanel panel, panel2, panel3, panel4;
    private JTextField jt;
    private ImageIcon i3, i4, i5, i6;

    public DeleteNotify() {
        fr = new JFrame("Alet Delete");
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        i3 = new ImageIcon("src/UI/Image/5.jpg");
        i4 = new ImageIcon(i3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i5 = new ImageIcon("src/UI/Image/6.jpg");
        i6 = new ImageIcon(i5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        label = new JLabel("Please Enter Your Project Name");
        label.setFont(new Font("Aria", Font.BOLD, 16));
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setBackground(new java.awt.Color(255, 255, 255));
        label2 = new JLabel("");
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        bn1 = new JButton("Delete");
        bn1.setForeground(Color.RED);
        bn1.setPreferredSize(new Dimension(100, 25));
        bn1.setFont(new Font("Aria", Font.BOLD, 13));
        bn1.setBorder(new LineBorder(Color.RED, 2));

        jt = new JTextField();
        jt.setColumns(20);
        jt.setBorder(new LineBorder(new java.awt.Color(255, 255, 255), 2));
        jt.setFont(new Font("Aria", Font.BOLD, 13));
        jt.setForeground(new java.awt.Color(255, 255, 255));
        jt.setBackground(new java.awt.Color(69, 104, 159));
        jt.setHorizontalAlignment(SwingConstants.CENTER);

        panel.setLayout(new FlowLayout());
        panel.add(label);

        panel2.setLayout(new FlowLayout());
        panel2.add(bn1);

        panel3.setLayout(new FlowLayout());
        panel3.add(jt);

        panel4.setLayout(new GridLayout(5, 0));
        panel4.add(label2);
        panel4.add(panel);
        panel4.add(panel3);
        panel4.add(panel2);
        panel4.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new java.awt.Color(101, 113, 132)));
        panel.setBackground(new java.awt.Color(69, 104, 159));
        panel2.setBackground(new java.awt.Color(69, 104, 159));
        panel3.setBackground(new java.awt.Color(69, 104, 159));
        panel4.setBackground(new java.awt.Color(69, 104, 159));

        fr.setIconImage(i4.getImage());
        fr.setLayout(new BorderLayout());
        fr.add(panel4);
        fr.setResizable(false);
        fr.setSize(320, 220);
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new DeleteNotify();
        });
    }
}
