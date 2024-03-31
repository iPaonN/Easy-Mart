package UI.View;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class ChangePassword {
    private JFrame fr;
    private JLabel label, label2, label3, la, la2, la3, la4, la5, la6;
    private JButton bn1;
    private JPanel panel, panel2, panel3, panel4, panel5, panel6, panel7;
    private JPasswordField jt, jt2;
    private ImageIcon i1, i2;
    public ChangePassword(){
        
        //Create
        i1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        fr = new JFrame("Change Password");
        label = new JLabel("Change Password");
        label2 = new JLabel("New password");
        label3 = new JLabel("Confirm password");
        la2 = new JLabel("         ");
        la3 = new JLabel("         ");
        la4 = new JLabel();
        la5 = new JLabel();
        la6 = new JLabel();
        jt = new JPasswordField();
        jt2 = new JPasswordField();
        bn1 = new JButton("Change");
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        
        //Label set
        label.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 20));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        label2.setForeground(Color.WHITE);
        label3.setForeground(Color.WHITE);
        
        //JT1
        jt.setColumns(1);
        jt.setBackground(new java.awt.Color(69, 104, 159));
        jt.setForeground(Color.WHITE);
        jt.setBorder(new LineBorder(Color.WHITE, 2));
        jt.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 14));
        
        //JT2
        jt2.setColumns(1);
        jt2.setBackground(new java.awt.Color(69, 104, 159));
        jt2.setBorder(new LineBorder(Color.WHITE, 2));
        jt2.setForeground(Color.WHITE);
        jt2.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 14));
        
        //Bn1
        bn1 = new JButton("Change");
        bn1.setForeground(new java.awt.Color(69, 104, 159));
        bn1.setFont(new Font("Aria", Font.BOLD, 14));
        bn1.setBackground(Color.WHITE);
        bn1.setBorder(new LineBorder(new java.awt.Color(69, 104, 159), 4));
        bn1.setPreferredSize(new Dimension(80, 30));
        
        //P1
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,0 ));
        panel.add(label2);
        panel.add(jt);
        panel.add(label3);
        panel.add(jt2);
        panel.setBackground(new java.awt.Color(69, 104, 159));
        
        //P6
        panel6 = new JPanel();
        panel6.setPreferredSize(new Dimension(10, 20));
        panel6.setBackground(new java.awt.Color(69, 104, 159));
        
        //P2
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(10, 50));
        panel2.add(panel6, BorderLayout.NORTH);
        panel2.add(label);
        panel2.setBackground(new java.awt.Color(69, 104, 159));
        
        
        //P3
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2, 0));
        panel3.setBackground(new java.awt.Color(69, 104, 159));
        panel3.add(la4);
        panel3.add(panel5);
        
        //P5
        panel5.setLayout(new BorderLayout());
        panel5.add(bn1, BorderLayout.EAST);
        panel5.setBackground(new java.awt.Color(69, 104, 159));
 
        
        //P4
        panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        panel4.add(la2,BorderLayout.WEST);
        panel4.add(la3,BorderLayout.EAST);
        panel4.add(panel);
        panel4.setBackground(new java.awt.Color(69, 104, 159));
        
        //P7
        panel7.setLayout(new BorderLayout());
        panel7.setBackground(new java.awt.Color(69, 104, 159));
        panel7.add(panel2, BorderLayout.NORTH);
        panel7.add(panel4, BorderLayout.CENTER);
        panel7.add(panel3, BorderLayout.SOUTH);
        panel7.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        
        //JFrame
        fr.setIconImage(i2.getImage());
        fr.add(panel7);
        fr.setBackground(new java.awt.Color(69, 104, 159));
        fr.setResizable(true);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(400,250);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new ChangePassword();
    }
}
