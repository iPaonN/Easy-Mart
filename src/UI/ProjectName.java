
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ProjectName {
    private JFrame fr;
    private JLabel label, label2;
    private JButton bn1;
    private JPanel panel, panel2, panel3, panel4;
    private JTextField jt;
    private ImageIcon i1, i2;
    public ProjectName(){
        fr = new JFrame("ProjectName");
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        i1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        
        label = new JLabel("Project Name");
        label.setFont(new Font("Aria", Font.BOLD, 20));
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setBackground(new java.awt.Color(255, 255, 255));
        label2 = new JLabel("");
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        bn1 = new JButton("Enter");
        bn1.setForeground(new java.awt.Color(69, 104, 159));
        bn1.setPreferredSize(new Dimension(100, 25));
        bn1.setFont(new Font("Aria", Font.BOLD, 13));

        
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

        panel4.setLayout(new GridLayout(5,0));
        panel4.add(label2);
        panel4.add(panel);
        panel4.add(panel3);
        panel4.add(panel2);
        panel4.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new java.awt.Color(101, 113, 132)));
        panel.setBackground(new java.awt.Color(69, 104, 159));
        panel2.setBackground(new java.awt.Color(69, 104, 159));
        panel3.setBackground(new java.awt.Color(69, 104, 159));
        panel4.setBackground(new java.awt.Color(69, 104, 159));
        
        fr.setIconImage(i2.getImage());
        fr.setLayout(new BorderLayout());
        fr.add(panel4);
        fr.setResizable(false);
        fr.setSize(320,220);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new ProjectName();
        });
    }
}

