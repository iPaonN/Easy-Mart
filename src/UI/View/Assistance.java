package UI.View;

import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

public class Assistance extends JPanel {

    private JFrame fr;
    private JLabel label, label2, label3, label4, label5;
    private JButton bn1, bn2;
    private JPanel panel, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel10, pa1, pa2, pa3, pa4;
    private JPanel pempty1, pempty2, pempty3, pempty4, pempty5, pempty6, pempty7, pempty8;
    private ImageIcon i1, i2;
    private RoundedButton rb1;
    private RoundedButton2 rb2;

    public Assistance() {
        rb1 = new RoundedButton();
        rb2 = new RoundedButton2();
        i1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        fr = new JFrame("ASSISTANCE");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("ASSISTANCE");
        label.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 60));
        label.setForeground(new java.awt.Color(69, 104, 159));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        label2 = new JLabel("Products should be reduced.");
        label2.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 20));
        label2.setForeground(new java.awt.Color(69, 104, 159));
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        label3 = new JLabel("Products should be add.");
        label3.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 25));
        label3.setForeground(new java.awt.Color(69, 104, 159));
        label3.setHorizontalAlignment(SwingConstants.CENTER);

        label4 = new JLabel("  ");
        label4.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 40));

        label5 = new JLabel("  ");
        label5.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 30));

        bn1 = new JButton("View");
        bn1.setForeground(new java.awt.Color(69, 104, 159));
        bn1.setPreferredSize(new Dimension(150, 40));
        bn1.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 20));
        bn1.setBackground(Color.WHITE);
        bn1.setBorder(new LineBorder(new java.awt.Color(69, 104, 159), 3));

        bn2 = new JButton("View");
        bn2.setForeground(new java.awt.Color(69, 104, 159));
        bn2.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 20));
        bn2.setPreferredSize(new Dimension(150, 40));
        bn2.setBackground(Color.WHITE);
        bn2.setBorder(new LineBorder(new java.awt.Color(69, 104, 159), 3));

        pa1 = new JPanel();
        pa1.setLayout(new BorderLayout());
        pa1.add(rb1);
        pa1.add(new JLabel("                                    "), BorderLayout.EAST);
        pa1.add(new JLabel("                                    "), BorderLayout.WEST);

        pa1.setBackground(new java.awt.Color(255, 255, 255));

        pa2 = new JPanel();
        pa2.setLayout(new BorderLayout());
        pa2.add(rb2);
        pa2.add(new JLabel("                                    "), BorderLayout.EAST);
        pa2.add(new JLabel("                                    "), BorderLayout.WEST);
        pa2.setBackground(new java.awt.Color(255, 255, 255));

        pa3 = new JPanel();
        pa3.setLayout(new BorderLayout());
        pa3.setBackground(new java.awt.Color(255, 255, 255));

        pa4 = new JPanel();
        pa4.setLayout(new BorderLayout());
        pa4.setBackground(new java.awt.Color(255, 255, 255));

        pempty1 = new JPanel();
        pempty1.setLayout(new BorderLayout());
        pempty1.setPreferredSize(new Dimension(20, 10));
        pempty1.setBackground(new java.awt.Color(255, 255, 255));

        pempty2 = new JPanel();
        pempty2.setLayout(new BorderLayout());
        pempty2.setPreferredSize(new Dimension(20, 20));
        pempty2.setBackground(new java.awt.Color(255, 255, 255));

        pempty3 = new JPanel();
        pempty3.setLayout(new BorderLayout());
        pempty3.setPreferredSize(new Dimension(20, 20));
        pempty3.setBackground(new java.awt.Color(255, 255, 255));

        pempty4 = new JPanel();
        pempty4.setLayout(new BorderLayout());
        pempty4.setPreferredSize(new Dimension(20, 10));
        pempty4.setBackground(new java.awt.Color(255, 255, 255));

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        pa3.add(label2);
        pa3.add(pempty1, BorderLayout.NORTH);
        panel.add(pa3, BorderLayout.NORTH);
        panel.add(pa1);
        panel.setBackground(new java.awt.Color(255, 255, 255));

        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        pa4.add(label3);
        pa4.add(pempty4, BorderLayout.NORTH);
        panel2.add(pa4, BorderLayout.NORTH);
        panel2.add(pa2);
        panel2.setBackground(new java.awt.Color(255, 255, 255));

        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add(panel2);
        panel3.setBorder(BorderFactory.createMatteBorder(40, 8, 8, 8, new java.awt.Color(69, 104, 159)));
        panel3.setBackground(new java.awt.Color(255, 255, 255));

        //panel4 = new JPanel();
        //panel4.setLayout(new BorderLayout());
        //panel4.add(panel);
        //panel4.setBorder(BorderFactory.createMatteBorder(40, 8, 8, 8, new java.awt.Color(69, 104, 159)));
        //panel4.setBackground(new java.awt.Color(255, 255, 255));

        panel5 = new JPanel();
        panel5.setLayout(new BorderLayout());
        panel5.add(panel3);
        panel5.add(new JLabel("               "), BorderLayout.SOUTH);
        panel5.add(new JLabel("               "), BorderLayout.EAST);
        panel5.add(new JLabel("               "), BorderLayout.NORTH);
        panel5.add(new JLabel("               "), BorderLayout.WEST);
        panel5.setBackground(new java.awt.Color(255, 255, 255));

        panel6 = new JPanel();
        panel6.setLayout(new BorderLayout());
        //panel6.add(panel4);
        panel6.add(new JLabel("               "), BorderLayout.SOUTH);
        panel6.add(new JLabel("               "), BorderLayout.EAST);
        panel6.add(new JLabel("               "), BorderLayout.NORTH);
        panel6.add(new JLabel("               "), BorderLayout.WEST);
        panel6.setBackground(new java.awt.Color(255, 255, 255));

        panel7 = new JPanel();
        pempty7 = new JPanel();
        pempty7.setBackground(Color.WHITE);
        pempty7.setLayout(new BorderLayout());
        pempty7.setPreferredSize(new Dimension(200, 180));
        
        pempty8 = new JPanel();
        pempty8.setBackground(Color.WHITE);
        pempty8.setLayout(new BorderLayout());
        pempty8.setPreferredSize(new Dimension(200, 30));
        panel7.setLayout(new BorderLayout());
        
        panel7.add(panel5);
        //panel7.add(panel6);
        panel7.add(new JLabel("                                                                                  "), BorderLayout.WEST);
        panel7.add(new JLabel("                                                                                  "), BorderLayout.EAST);
        panel7.add(pempty7, BorderLayout.SOUTH);
        panel7.add(pempty8, BorderLayout.NORTH);
        panel7.setBackground(new java.awt.Color(255, 255, 255));

        panel10 = new JPanel();
        panel10.setLayout(new BorderLayout());
        panel10.add(label4, BorderLayout.NORTH);
        panel10.add(label);
        panel10.add(label5, BorderLayout.SOUTH);
        panel10.setBackground(new java.awt.Color(255, 255, 255));

        panel8 = new JPanel();
        panel8.setLayout(new BorderLayout());
        panel8.add(panel10, BorderLayout.NORTH);
        panel8.add(new JLabel("               "), BorderLayout.SOUTH);
        panel8.add(panel7);
        panel8.setBackground(new java.awt.Color(255, 255, 255));
        panel8.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new java.awt.Color(69, 104, 159)));

        this.setLayout(new BorderLayout());
        this.add(panel8);
        this.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, new java.awt.Color(101, 113, 132)));

        fr.setIconImage(i2.getImage());
        fr.setLayout(new BorderLayout());
        fr.add(this);
        fr.setSize(1280, 720);
        fr.setLocationRelativeTo(null);
        fr.setVisible(false);
    }

    public RoundedButton getBn1(){
        return rb1;
    }
    
    public RoundedButton2 getBn2(){
        return rb2;
    }
    
    public static void main(String[] args) {
        new Assistance();
    }
}
