package FrontendUI;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Login {

    private JFrame fr1;
    private JLabel j1, j2, j3, j4, j5, j6, j9, j12, j13, j14, j15, j16, j17;
    private JTextField tf1, tf2;
    private JCheckBox jb1;
    private JButton b2;
    private JPanel p1, p2, p3, p4, p5, P6, P7, P8, P9, P10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22;
    private ImageIcon i1, i2, i3, i4, i5, i6, i7, i8;
    private Circle c1;

    public Login() {

        //Create component 
        fr1 = new JFrame("EasyMart");
        c1 = new Circle();
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
        i1 = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\ProjectFrontend\\src\\FrontendUI\\eweweewew.jpg");
        i2 = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\ProjectFrontend\\src\\FrontendUI\\username.png");
        i3 = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\ProjectFrontend\\src\\FrontendUI\\password.png");
        i6 = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\ProjectFrontend\\src\\FrontendUI\\image_5.png");
        i4 = new ImageIcon(i2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i5 = new ImageIcon(i3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i7 = new ImageIcon(i6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        i8 = new ImageIcon("C:\\Users\\User\\Desktop\\291964288_5968447443172599_510524243317264435_n.jpg");
        j1 = new JLabel(" Username", i4, 2);
        j2 = new JLabel(" Password", i5, 2);
        j3 = new JLabel("Forget password ?", i7, 2);
        j4 = new JLabel("Don't have an account ?");
        j5 = new JLabel("register");
        j6 = new JLabel();
        j9 = new JLabel();
        j12 = new JLabel();
        j13 = new JLabel("W E I C O M E !");
        tf1 = new JTextField(33);
        tf2 = new JTextField(33);
        jb1 = new JCheckBox("Remember me");
        b2 = new JButton("Login");
        j14 = new JLabel(i8);
        j15 = new JLabel("S I G N  I N");
        j16 = new JLabel();
        j17 = new JLabel();

        //Set component 
        fr1.setLayout(new GridLayout(1, 1));
        p1.setLayout(new BorderLayout());
        p1.setBackground(new Color(157, 178, 191));

        p2.setLayout(new GridLayout(7, 0));
        p2.setBackground(new Color(69, 104, 159));

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
        p12.add(j2);
        P8.add(p14);
        p14.add(tf2);
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
        c1.setPreferredSize(new Dimension(640, 460));
        p18.add(c1);
        p19.setLayout(new BorderLayout());
        p19.setPreferredSize(new Dimension(640, 180));
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
        p18.setBackground(new Color(157, 178, 191));
        p19.setBackground(new Color(157, 178, 191));
        p20.setBackground(new Color(69, 104, 159));
        p21.setBackground(new Color(69, 104, 159));
        p22.setBackground(new Color(157, 178, 191));
        jb1.setBackground(new Color(69, 104, 159));
        jb1.setForeground(Color.WHITE);

        //Set Font
        j1.setFont(new Font("Arial", Font.BOLD, 20));
        j1.setForeground(Color.WHITE);
        j2.setFont(new Font("Arial", Font.BOLD, 20));
        j2.setForeground(Color.WHITE);
        j3.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        j3.setForeground(Color.WHITE);
        j4.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        j4.setForeground(Color.WHITE);
        j5.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        j5.setForeground(Color.WHITE);
        j13.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
        j13.setForeground(Color.WHITE);
        j14.setFont(new Font("Arial", Font.CENTER_BASELINE, 700));
        j14.setForeground(Color.WHITE);
        j15.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
        j15.setForeground(Color.WHITE);

        //Set TextField
        tf1.setForeground(Color.WHITE);
        tf1.setFont(new Font("Arial", Font.PLAIN, 18));
        tf1.setBackground(new Color(69, 104, 159));
        tf1.setBorder(new LineBorder(Color.WHITE, 2));
        tf2.setForeground(Color.WHITE);
        tf2.setBackground(new Color(69, 104, 159));
        tf2.setBorder(new LineBorder(Color.WHITE, 2));
        tf2.setFont(new Font("Arial", Font.PLAIN, 18));

        //Frame add
        fr1.add(p1);
        fr1.add(p2);
        fr1.setBackground(new Color(157, 178, 191));
        fr1.setResizable(true);
        fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr1.setVisible(true);
        fr1.setSize(1280, 720);
        fr1.setIconImage(i1.getImage());
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
