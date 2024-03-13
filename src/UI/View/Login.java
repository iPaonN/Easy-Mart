package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Login {
    
    private JFrame fr1;
    private JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17;
    private JLabel jaletusername;
    private JTextField tf1;
    private JPasswordField pf1;
    private JCheckBox jb1;
    private JButton b1, b2, b3, b4;
    private JPanel p1, p2, p3, p4, p5, P6, P7, P8, P9, P10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24;
    private ImageIcon i1, i2, i3, i4, i5, i6, i7, i8;
    private Circle c1;

    public Login() {
        
        //Create component 
        fr1 = new JFrame("EasyMart");
        c1 = new Circle();
        c1.LoadImage("src/UI.Image/3.jpg");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        P6 = new JPanel();
        P7 = new JPanel();
        P8 = new JPanel();
        P9 = new JPanel();
        P10 = new JPanel();
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
        i1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        i2 = new ImageIcon("src/UI/Image/username.png");
        i3 = new ImageIcon("src/UI/Image/password.png");
        i6 = new ImageIcon("src/UI/Image/image_5.png");
        i4 = new ImageIcon(i2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i5 = new ImageIcon(i3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i7 = new ImageIcon(i6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i8 = new ImageIcon("src/UI/Image/image_5.png");
        j1 = new JLabel("Username", i4, 2);
        j2 = new JLabel("Password", i5, 2);
        j3 = new JLabel("Forget password ?", i7, 2);
        j4 = new JLabel("Don't have an account ?");
        j5 = new JLabel("register");
        j6 = new JLabel();
        j7 = new JLabel();
        j8 = new JLabel();
        j9 = new JLabel();
        j10 = new JLabel();
        j11 = new JLabel();
        j12 = new JLabel();
        j13 = new JLabel("W E I C O M E !");
        tf1 = new JTextField(33);
        pf1 = new JPasswordField(33);
        jb1 = new JCheckBox("Remember me");
        b1 = new JButton();
        b2 = new JButton("Login");
        b3 = new JButton();
        b4 = new JButton();
        j14 = new JLabel(i8);
        j15 = new JLabel("S I G N  I N");
        j16 = new JLabel();
        j17 = new JLabel();
        jaletusername = new JLabel("");
        
        //Set component 
        fr1.setLayout(new GridLayout(1, 1));
        p1.setLayout(new BorderLayout());
        p1.setBackground(new Color(101, 113, 132));
        p2.setLayout(new GridLayout(7, 0));
        p2.setBackground(new Color(69, 104, 159));

        //P5
        p5.setLayout(new BorderLayout());

        //P6
        P6.setLayout(new GridLayout(3, 0));
        j15.setHorizontalAlignment(SwingConstants.CENTER);
        P6.add(j16);
        P6.add(j17);
        P6.add(j15);

        //P7 add
        P7.setLayout(new GridLayout(3, 0));
        p11.setLayout(new GridLayout(0, 3));
        p20.setLayout(new BorderLayout());
        P7.add(p20);
        P7.add(p11);
        j1.setHorizontalAlignment(SwingConstants.RIGHT);
        p11.add(j1);
        P7.add(p13);
        p13.add(tf1);

        // P8 add
        P8.setLayout(new GridLayout(3, 0));
        p12.setLayout(new GridLayout(0, 3));
        p15.setLayout(new GridLayout(0, 3));
        P8.add(p12);
        j2.setHorizontalAlignment(SwingConstants.RIGHT);
        jb1.setHorizontalAlignment(SwingConstants.RIGHT);
        jaletusername.setHorizontalAlignment(SwingConstants.LEFT);
        p12.add(j2);
        p12.add(new JLabel());
        p12.add(jaletusername);
        P8.add(p14);
        p14.add(pf1);
        P8.add(p15);
        p15.add(jb1);
        p15.add(j6);
        p15.add(j3);

        // P9 add
        P9.setLayout(new GridLayout(4, 0));
        p16.setLayout(new GridLayout(0, 3));
        P9.add(p21);
        P9.add(p16);
        b2.setFont(new Font("Arial", Font.BOLD, 12));
        b2.setHorizontalAlignment(SwingConstants.CENTER);
        b2.setBackground(Color.WHITE);
        b2.setForeground(new Color(69, 104, 159));
        b2.setPreferredSize(new Dimension(20, 20));
        p16.add(j9);
        p16.add(b2);
        p16.add(j12);
        j4.setHorizontalAlignment(SwingConstants.CENTER);
        j5.setHorizontalAlignment(SwingConstants.CENTER);
        P9.add(j4);
        P9.add(j5);

        // P1 add
        p18.setLayout(new BorderLayout());
        p18.setPreferredSize(new Dimension(570, 460));
        p23.setPreferredSize(new Dimension(100, 460));
        p24.setPreferredSize(new Dimension(100, 460));
        p18.add(c1, BorderLayout.CENTER);
        p18.add(p23, BorderLayout.WEST);
        p18.add(p24, BorderLayout.EAST);
        p19.setLayout(new BorderLayout());
        p19.setPreferredSize(new Dimension(210, 180));
        p1.add(p18, BorderLayout.CENTER);
        j13.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(p19, BorderLayout.SOUTH);
        p19.add(j13);
        p22.setPreferredSize(new Dimension(80, 80));
        p1.add(p22, BorderLayout.NORTH);

        //P2 add
        p2.add(p5);
        p2.add(P6);
        p2.add(P7);
        p2.add(P8);
        p2.add(P9);
        p2.add(P10);

        //Set Background
        p5.setLayout(new BorderLayout());
        p5.setBackground(new Color(69, 104, 159));
        P6.setBackground(new Color(69, 104, 159));
        P7.setBackground(new Color(69, 104, 159));
        P8.setBackground(new Color(69, 104, 159));
        P9.setBackground(new Color(69, 104, 159));
        P10.setBackground(new Color(69, 104, 159));
        p11.setBackground(new Color(69, 104, 159));
        p12.setBackground(new Color(69, 104, 159));
        p13.setBackground(new Color(69, 104, 159));
        p14.setBackground(new Color(69, 104, 159));
        p15.setBackground(new Color(69, 104, 159));
        p16.setBackground(new Color(69, 104, 159));
        p17.setBackground(new Color(69, 104, 159));
        p18.setBackground(new Color(101, 113, 132));
        p19.setBackground(new Color(101, 113, 132));
        p20.setBackground(new Color(69, 104, 159));
        p21.setBackground(new Color(69, 104, 159));
        p22.setBackground(new Color(101, 113, 132));
        p23.setBackground(new Color(101, 113, 132));
        p24.setBackground(new Color(101, 113, 132));
        jb1.setBackground(new Color(69, 104, 159));
        jb1.setForeground(Color.WHITE);

        //Set Font
        j1.setFont(new Font("Arial", Font.BOLD, 20));
        j1.setForeground(Color.WHITE);
        j2.setFont(new Font("Arial", Font.BOLD, 20));
        j2.setForeground(Color.WHITE);
        j3.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        j3.setForeground(Color.WHITE);
        j4.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        j4.setForeground(Color.WHITE);
        j5.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        j5.setForeground(Color.WHITE);
        j13.setFont(new Font("Arial", Font.CENTER_BASELINE, 50));
        j13.setForeground(Color.WHITE);
        j14.setFont(new Font("Arial", Font.CENTER_BASELINE, 700));
        j14.setForeground(Color.WHITE);
        j15.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
        j15.setForeground(Color.WHITE);
        jaletusername.setFont(new Font("Arial", Font.CENTER_BASELINE, 11));
        jaletusername.setForeground(new Color(250, 199, 16));

        //Set TextField and JPasswordField
        tf1.setForeground(Color.WHITE);
        tf1.setFont(new Font("Arial", Font.PLAIN, 18));
        tf1.setBackground(new Color(69, 104, 159));
        tf1.setBorder(new LineBorder(Color.WHITE, 2));
        pf1.setForeground(Color.WHITE);
        pf1.setBackground(new Color(69, 104, 159));
        pf1.setBorder(new LineBorder(Color.WHITE, 2));
        pf1.setFont(new Font("Arial", Font.PLAIN, 18));

        //Frame add
        fr1.add(p1);
        fr1.add(p2);
        fr1.setBackground(new Color(101, 113, 132));
        fr1.setResizable(true);
        fr1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr1.setVisible(true);
        fr1.setSize(1280, 720);
        fr1.setIconImage(i1.getImage());
    }

    public JFrame getFr1() {
        return fr1;
    }

    public void setFr1(JFrame fr1) {
        this.fr1 = fr1;
    }

    public JLabel getJ1() {
        return j1;
    }

    public void setJ1(JLabel j1) {
        this.j1 = j1;
    }

    public JLabel getJ2() {
        return j2;
    }

    public void setJ2(JLabel j2) {
        this.j2 = j2;
    }

    public JLabel getJ3() {
        return j3;
    }

    public void setJ3(JLabel j3) {
        this.j3 = j3;
    }

    public JLabel getJ4() {
        return j4;
    }

    public void setJ4(JLabel j4) {
        this.j4 = j4;
    }

    public JLabel getJ5() {
        return j5;
    }

    public void setJ5(JLabel j5) {
        this.j5 = j5;
    }

    public JLabel getJ6() {
        return j6;
    }

    public void setJ6(JLabel j6) {
        this.j6 = j6;
    }

    public JLabel getJ7() {
        return j7;
    }

    public void setJ7(JLabel j7) {
        this.j7 = j7;
    }

    public JLabel getJ8() {
        return j8;
    }

    public void setJ8(JLabel j8) {
        this.j8 = j8;
    }

    public JLabel getJ9() {
        return j9;
    }

    public void setJ9(JLabel j9) {
        this.j9 = j9;
    }

    public JLabel getJ10() {
        return j10;
    }

    public void setJ10(JLabel j10) {
        this.j10 = j10;
    }

    public JLabel getJ11() {
        return j11;
    }

    public void setJ11(JLabel j11) {
        this.j11 = j11;
    }

    public JLabel getJ12() {
        return j12;
    }

    public void setJ12(JLabel j12) {
        this.j12 = j12;
    }

    public JLabel getJ13() {
        return j13;
    }

    public void setJ13(JLabel j13) {
        this.j13 = j13;
    }

    public JLabel getJ14() {
        return j14;
    }

    public void setJ14(JLabel j14) {
        this.j14 = j14;
    }

    public JLabel getJ15() {
        return j15;
    }

    public void setJ15(JLabel j15) {
        this.j15 = j15;
    }

    public JLabel getJ16() {
        return j16;
    }

    public void setJ16(JLabel j16) {
        this.j16 = j16;
    }

    public JLabel getJ17() {
        return j17;
    }

    public void setJ17(JLabel j17) {
        this.j17 = j17;
    }

    public JLabel getJaletusername() {
        return jaletusername;
    }

    public void setJaletusername(JLabel jaletusername) {
        this.jaletusername = jaletusername;
    }

    public JTextField getTf1() {
        return tf1;
    }

    public void setTf1(JTextField tf1) {
        this.tf1 = tf1;
    }

    public JPasswordField getPf1() {
        return pf1;
    }

    public void setPf1(JPasswordField pf1) {
        this.pf1 = pf1;
    }

    public JCheckBox getJb1() {
        return jb1;
    }

    public void setJb1(JCheckBox jb1) {
        this.jb1 = jb1;
    }

    public JButton getB1() {
        return b1;
    }

    public void setB1(JButton b1) {
        this.b1 = b1;
    }

    public JButton getB2() {
        return b2;
    }

    public void setB2(JButton b2) {
        this.b2 = b2;
    }

    public JButton getB3() {
        return b3;
    }

    public void setB3(JButton b3) {
        this.b3 = b3;
    }

    public JButton getB4() {
        return b4;
    }

    public void setB4(JButton b4) {
        this.b4 = b4;
    }

    public JPanel getP1() {
        return p1;
    }

    public void setP1(JPanel p1) {
        this.p1 = p1;
    }

    public JPanel getP2() {
        return p2;
    }

    public void setP2(JPanel p2) {
        this.p2 = p2;
    }

    public JPanel getP3() {
        return p3;
    }

    public void setP3(JPanel p3) {
        this.p3 = p3;
    }

    public JPanel getP4() {
        return p4;
    }

    public void setP4(JPanel p4) {
        this.p4 = p4;
    }

    public JPanel getP5() {
        return p5;
    }

    public void setP5(JPanel p5) {
        this.p5 = p5;
    }

    public JPanel getP6() {
        return P6;
    }

    public void setP6(JPanel P6) {
        this.P6 = P6;
    }

    public JPanel getP7() {
        return P7;
    }

    public void setP7(JPanel P7) {
        this.P7 = P7;
    }

    public JPanel getP8() {
        return P8;
    }

    public void setP8(JPanel P8) {
        this.P8 = P8;
    }

    public JPanel getP9() {
        return P9;
    }

    public void setP9(JPanel P9) {
        this.P9 = P9;
    }

    public JPanel getP10() {
        return P10;
    }

    public void setP10(JPanel P10) {
        this.P10 = P10;
    }

    public JPanel getP11() {
        return p11;
    }

    public void setP11(JPanel p11) {
        this.p11 = p11;
    }

    public JPanel getP12() {
        return p12;
    }

    public void setP12(JPanel p12) {
        this.p12 = p12;
    }

    public JPanel getP13() {
        return p13;
    }

    public void setP13(JPanel p13) {
        this.p13 = p13;
    }

    public JPanel getP14() {
        return p14;
    }

    public void setP14(JPanel p14) {
        this.p14 = p14;
    }

    public JPanel getP15() {
        return p15;
    }

    public void setP15(JPanel p15) {
        this.p15 = p15;
    }

    public JPanel getP16() {
        return p16;
    }

    public void setP16(JPanel p16) {
        this.p16 = p16;
    }

    public JPanel getP17() {
        return p17;
    }

    public void setP17(JPanel p17) {
        this.p17 = p17;
    }

    public JPanel getP18() {
        return p18;
    }

    public void setP18(JPanel p18) {
        this.p18 = p18;
    }

    public JPanel getP19() {
        return p19;
    }

    public void setP19(JPanel p19) {
        this.p19 = p19;
    }

    public JPanel getP20() {
        return p20;
    }

    public void setP20(JPanel p20) {
        this.p20 = p20;
    }

    public JPanel getP21() {
        return p21;
    }

    public void setP21(JPanel p21) {
        this.p21 = p21;
    }

    public JPanel getP22() {
        return p22;
    }

    public void setP22(JPanel p22) {
        this.p22 = p22;
    }

    public JPanel getP23() {
        return p23;
    }

    public void setP23(JPanel p23) {
        this.p23 = p23;
    }

    public JPanel getP24() {
        return p24;
    }

    public void setP24(JPanel p24) {
        this.p24 = p24;
    }

    public ImageIcon getI1() {
        return i1;
    }

    public void setI1(ImageIcon i1) {
        this.i1 = i1;
    }

    public ImageIcon getI2() {
        return i2;
    }

    public void setI2(ImageIcon i2) {
        this.i2 = i2;
    }

    public ImageIcon getI3() {
        return i3;
    }

    public void setI3(ImageIcon i3) {
        this.i3 = i3;
    }

    public ImageIcon getI4() {
        return i4;
    }

    public void setI4(ImageIcon i4) {
        this.i4 = i4;
    }

    public ImageIcon getI5() {
        return i5;
    }

    public void setI5(ImageIcon i5) {
        this.i5 = i5;
    }

    public ImageIcon getI6() {
        return i6;
    }

    public void setI6(ImageIcon i6) {
        this.i6 = i6;
    }

    public ImageIcon getI7() {
        return i7;
    }

    public void setI7(ImageIcon i7) {
        this.i7 = i7;
    }

    public ImageIcon getI8() {
        return i8;
    }

    public void setI8(ImageIcon i8) {
        this.i8 = i8;
    }

    public Circle getC1() {
        return c1;
    }

    public void setC1(Circle c1) {
        this.c1 = c1;
    }

    

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new Login();
        });
        
    }
}
