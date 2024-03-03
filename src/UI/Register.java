package UI;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Register {
    private JFrame fr1;
    private JPanel p1, P2, P3, P4, P5, P6, P7, P8, P9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27;
    private JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26;
    private JButton b1, b2, b3, b4;
    private JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    private JPasswordField pf1, pf2;
    private ImageIcon i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14;
    public Register(){
        
        //Create component
        
        fr1 = new JFrame("Register");
        p1 = new JPanel();
        P2 = new JPanel();
        P3 = new JPanel();
        P4 = new JPanel();
        P5 = new JPanel();
        P6 = new JPanel();
        P7 = new JPanel();
        P8 = new JPanel();
        P9 = new JPanel();
        p10 = new JPanel();
        p11 = new JPanel();
        p12 = new JPanel();
        p13 = new JPanel();
        p14 = new JPanel();
        p15 = new JPanel();
        p16 = new JPanel();
        p17 = new JPanel();
        p18 = new JPanel();
        p19 = new JPanel();
        p20 = new JPanel();
        p21 = new JPanel();
        p22 = new JPanel();
        p23 = new JPanel();
        p24 = new JPanel();
        p25 = new JPanel();
        p26 = new JPanel();
        p27 = new JPanel();
        i1 = new ImageIcon("src/UI/Image/username.png");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i3 = new ImageIcon("src/UI/Image/password.png");
        i4 = new ImageIcon(i3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i5 = new ImageIcon("src/UI/Image/image_5.png");
        i6 = new ImageIcon(i5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i7 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        i8 = new ImageIcon(i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i9 = new ImageIcon("src/UI/Image/eye.jpg");
        i10 = new ImageIcon(i9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i11 = new ImageIcon("src/UI/Image/username.jpg");
        i12 = new ImageIcon(i11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i13 = new ImageIcon();
        i14 = new ImageIcon();
        j1 = new JLabel("Username", i2, 2);
        j2 = new JLabel("Email", i4, 0);
        j3 = new JLabel("First Name", i2, 0);
        j4 = new JLabel("Last Name", i2, 0);
        j5 = new JLabel("New password", i6, 0);
        j6 = new JLabel("Confirm password", i6, 0);
        j7 = new JLabel("REGISTER");
        j8 = new JLabel();
        j9 = new JLabel();
        j10 = new JLabel();
        j11 = new JLabel();
        j12 = new JLabel();
        j13 = new JLabel();
        j14 = new JLabel();
        j15 = new JLabel();
        j16 = new JLabel();
        j17 = new JLabel();
        j18 = new JLabel();
        j19 = new JLabel();
        j20 = new JLabel();
        j21 = new JLabel();
        j22 = new JLabel();
        j23 = new JLabel();
        j24 = new JLabel();
        j25 = new JLabel();
        j26 = new JLabel();
        b1 = new JButton("Create");
        b2 = new JButton(i10);
        b3 = new JButton(i10);
        b4 = new JButton();
        tf1 = new JTextField(21);
        tf2 = new JTextField(21);
        tf3 = new JTextField(21);
        tf4 = new JTextField(21);
        pf1 = new JPasswordField(19);
        pf2 = new JPasswordField(19); 
        
        //P1 add
        
        p1.setLayout(new GridLayout(8, 0));
        p1.add(P2);
        p1.add(P3);
        p1.add(P4);
        p1.add(P5);
        p1.add(P6);
        p1.add(P7);
        p1.add(P8);
        p1.add(P9);
        
        //P2 add
        
        P2.setLayout(new BorderLayout());
        j7.setHorizontalAlignment(SwingConstants.CENTER);
        P2.add(j7);
        
        //P3 add
        
        P3.setLayout(new GridLayout(3, 0));
        j1.setHorizontalAlignment(SwingConstants.RIGHT);
        P3.add(p10);
        p10.add(j1);
        j21.setPreferredSize(new Dimension(tf1.getColumns()*7, 10));
        p10.add(j21);
        P3.add(p11);
        p11.add(tf1);
        P3.add(p12);
        
        //P4 add
        
        P4.setLayout(new GridLayout(3, 0));
        j2.setHorizontalAlignment(SwingConstants.RIGHT);
        j22.setPreferredSize(new Dimension(tf1.getColumns()*9, 10));
        p13.add(j2);
        p13.add(j22);
        P4.add(p13);
        P4.add(p14);
        p14.add(tf2);
        P4.add(p15);
        
        //P5 add
        
        P5.setLayout(new GridLayout(3, 0));
        j3.setHorizontalAlignment(SwingConstants.RIGHT);
        j23.setPreferredSize(new Dimension(tf1.getColumns()+120, 10));
        p16.add(j3);
        p16.add(j23);
        p17.add(tf3);
        P5.add(p16);
        P5.add(p17);
        P5.add(p18);
        
        //P6 add
        
        P6.setLayout(new GridLayout(3, 0));
        j4.setHorizontalAlignment(SwingConstants.RIGHT);
        j24.setPreferredSize(new Dimension(tf1.getColumns()+122, 10));
        p19.add(j4);
        p19.add(j24);
        p20.add(tf4);
        P6.add(p19);
        P6.add(p20);
        P6.add(p21);
        
        //P7 add
        
        P7.setLayout(new GridLayout(3, 0));
        j5.setHorizontalAlignment(SwingConstants.RIGHT);
        j25.setPreferredSize(new Dimension(tf1.getColumns()*5, 10));
        p22.add(j5);
        p22.add(j25);
        p23.add(pf1);
        p23.add(b2);
        b2.setPreferredSize(new Dimension(23, 24));
        b2.setBackground(Color.WHITE);
        b2.setBorder(new LineBorder(new Color(69,104,159), 1));
        P7.add(p22);
        P7.add(p23);
        P7.add(p24);
        
        //P8 add
        
        P8.setLayout(new GridLayout(3, 0));
        j6.setHorizontalAlignment(SwingConstants.RIGHT);
        j26.setPreferredSize(new Dimension(tf1.getColumns()+54, 10));
        p25.add(j6);
        p25.add(j26);
        p26.add(pf2);
        b3.setPreferredSize(new Dimension(23, 24));
        b3.setBackground(Color.WHITE);
        b3.setBorder(new LineBorder(new Color(69,104,159), 1));
        p26.add(b3);
        P8.add(p25);
        P8.add(p26);
        P8.add(p27);
        
        //P9 add
        
        P9.setLayout(new GridLayout(2, 0));
        P9.add(j20);
        P9.add(b1);
        b1.setHorizontalAlignment(SwingConstants.CENTER);
        b1.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        b1.setBackground(Color.WHITE);
        b1.setForeground(new Color(69,104,159));
        
        //Set component
        
        p1.setBackground(Color.WHITE);
        P2.setBackground(new Color(69,104,159));
        P3.setBackground(new Color(69,104,159));
        P4.setBackground(new Color(69,104,159));
        P5.setBackground(new Color(69,104,159));
        P6.setBackground(new Color(69,104,159));
        P7.setBackground(new Color(69,104,159));
        P8.setBackground(new Color(69,104,159));
        P9.setBackground(new Color(69,104,159));
        p10.setBackground(new Color(69,104,159));
        p11.setBackground(new Color(69,104,159));
        p12.setBackground(new Color(69,104,159));
        p13.setBackground(new Color(69,104,159));
        p14.setBackground(new Color(69,104,159));
        p15.setBackground(new Color(69,104,159));
        p16.setBackground(new Color(69,104,159));
        p17.setBackground(new Color(69,104,159));
        p18.setBackground(new Color(69,104,159));
        p19.setBackground(new Color(69,104,159));
        p20.setBackground(new Color(69,104,159));
        p21.setBackground(new Color(69,104,159));
        p22.setBackground(new Color(69,104,159));
        p23.setBackground(new Color(69,104,159));
        p24.setBackground(new Color(69,104,159));
        p25.setBackground(new Color(69,104,159));
        p26.setBackground(new Color(69,104,159));
        p27.setBackground(new Color(69,104,159));
        
        //Set Font
        
        j1.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        j1.setForeground(Color.WHITE);
        j2.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        j2.setForeground(Color.WHITE);
        j3.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        j3.setForeground(Color.WHITE);
        j4.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        j4.setForeground(Color.WHITE);
        j5.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        j5.setForeground(Color.WHITE);
        j6.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        j6.setForeground(Color.WHITE);
        j7.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
        j7.setForeground(Color.WHITE);
        
        //Set TextField
        
        tf1.setBackground(new Color(69,104,159));
        tf1.setForeground(Color.WHITE);
        tf1.setBorder(new LineBorder(Color.WHITE, 2));
        tf1.setFont(new Font("Arial", Font.PLAIN, 16));
        tf2.setBackground(new Color(69,104,159));
        tf2.setForeground(Color.WHITE);
        tf2.setBorder(new LineBorder(Color.WHITE, 2));
        tf2.setFont(new Font("Arial", Font.PLAIN, 16));
        tf3.setBackground(new Color(69,104,159));
        tf3.setForeground(Color.WHITE);
        tf3.setBorder(new LineBorder(Color.WHITE, 2));
        tf3.setFont(new Font("Arial", Font.PLAIN, 16));
        tf4.setBackground(new Color(69,104,159));
        tf4.setForeground(Color.WHITE);
        tf4.setBorder(new LineBorder(Color.WHITE, 2));
        tf4.setFont(new Font("Arial", Font.PLAIN, 16));
        pf1.setBackground(new Color(69,104,159));
        pf1.setForeground(Color.WHITE);
        pf1.setBorder(new LineBorder(Color.WHITE, 2));
        pf1.setFont(new Font("Arial", Font.PLAIN, 16));
        pf2.setBackground(new Color(69,104,159));
        pf2.setForeground(Color.WHITE);
        pf2.setBorder(new LineBorder(Color.WHITE, 2));
        pf2.setFont(new Font("Arial", Font.PLAIN, 16));
        
        //Set JFrame
        
        fr1.setIconImage(i8.getImage());
        fr1.add(p1);
        fr1.setSize(400, 750);
        fr1.setResizable(false);
        fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr1.setVisible(true);
    }
    public static void main(String[] args) {
        new Register();
    }
}
