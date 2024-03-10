
import java.awt.*;
import javax.swing.*;

public class MainMenu {

    private JFrame fr;
    private JLabel label, uns1, j1, j2;
    private JLabel Jicon1, Jicon2, Jicon3;
    private JButton bn1, bn2, bn3, bn4, bn5, bn6, bn9, bn10;
    private JPanel panel, panel2, panel3, pane14, panel5, panel6, panel7, panel8;
    private ImageIcon icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9;
    private ImageIcon reicon1, reicon2, reicon3, reicon4, reicon5, reicon6, reicon9, reicon10, reicon11;
    private GridBagConstraints gb1;
    private StockProduct Sp1;
    private History h1;
    private Member m1;
    private CircleProfile cp1;

    public MainMenu() {

        //Create
        cp1 = new CircleProfile();
        cp1.LoadImage("src/UI/Image/3.jpg");
        fr = new JFrame("MENU");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gb1 = new GridBagConstraints();
        Sp1 = new StockProduct();
        h1 = new History();
        m1 = new Member();
        icon1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon2 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon3 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon4 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon5 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon6 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon7 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon8 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        icon9 = new ImageIcon("src/UI/Image/username.png");
        reicon1 = new ImageIcon(icon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon2 = new ImageIcon(icon2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon3 = new ImageIcon(icon3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon4 = new ImageIcon(icon4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon5 = new ImageIcon(icon5.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon6 = new ImageIcon(icon6.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon9 = new ImageIcon(icon7.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        reicon10 = new ImageIcon(icon8.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        reicon11 = new ImageIcon(icon9.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        label = new JLabel("EASY MART", reicon10, 0);
        label.setBackground(new java.awt.Color(255, 255, 255));
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 40)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        uns1 = new JLabel("Tibet Sawangkan  ");
        uns1.setFont(new Font("Arial", Font.PLAIN, 14)); // NOI18N
        uns1.setForeground(new java.awt.Color(255, 255, 255));
        j1 = new JLabel("     ");
        j2 = new JLabel("   ");
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        Jicon1 = new JLabel(reicon11);

        //Bottom
        bn1 = new JButton("Dashboard");
        bn1.setPreferredSize(new Dimension(200, 10));
        bn1.setForeground(new java.awt.Color(69, 104, 159));
        bn1.setBackground(Color.WHITE);
        bn1.setFont(new Font("Arial", Font.BOLD, 14));
        bn2 = new JButton("Assistance");
        bn2.setForeground(new java.awt.Color(69, 104, 159));
        bn2.setBackground(Color.WHITE);
        bn2.setFont(new Font("Arial", Font.BOLD, 14));
        bn3 = new JButton("Product | Stock");
        bn3.setForeground(new java.awt.Color(69, 104, 159));
        bn3.setBackground(Color.WHITE);
        bn3.setFont(new Font("Arial", Font.BOLD, 14));
        bn4 = new JButton("Stock");
        bn4.setForeground(new java.awt.Color(69, 104, 159));
        bn4.setBackground(Color.WHITE);
        bn4.setFont(new Font("Arial", Font.BOLD, 14));
        bn5 = new JButton("History");
        bn5.setForeground(new java.awt.Color(69, 104, 159));
        bn5.setBackground(Color.WHITE);
        bn5.setFont(new Font("Arial", Font.BOLD, 14));
        bn6 = new JButton("Member");
        bn6.setForeground(new java.awt.Color(69, 104, 159));
        bn6.setBackground(Color.WHITE);
        bn6.setFont(new Font("Arial", Font.BOLD, 14));
        bn9 = new JButton("Option");
        bn9.setForeground(new java.awt.Color(69, 104, 159));
        bn9.setBackground(Color.WHITE);
        bn9.setFont(new Font("Arial", Font.BOLD, 14));
        bn10 = new JButton("Export");
        bn10.setForeground(new java.awt.Color(69, 104, 159));
        bn10.setBackground(Color.WHITE);
        bn10.setFont(new Font("Arial", Font.BOLD, 14));

        //Panel
        panel.setLayout(new GridLayout(13, 0, 0, 5));
        panel.add(bn1);
        panel.add(bn2);
        panel.add(bn3);

        //panel.add(bn4);
        panel.add(bn5);
        panel.add(bn6);
        panel.add(bn9);
        panel.add(bn10);
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, Color.white));
        panel2.setLayout(new BorderLayout());
        panel5.setLayout(new BorderLayout());
        panel6.setLayout(new BorderLayout());
        panel5.setPreferredSize(new Dimension(200, 5));
        panel6.setPreferredSize(new Dimension(200, 5));
        panel2.setBackground(new java.awt.Color(69, 104, 159));
        panel5.setBackground(new java.awt.Color(69, 104, 159));
        panel6.setBackground(new java.awt.Color(69, 104, 159));
        panel7.setBackground(new java.awt.Color(69, 104, 159));
        panel8.setBackground(new java.awt.Color(69, 104, 159));
        panel2.add(label, BorderLayout.WEST);
        panel2.add(panel7, BorderLayout.EAST);
        panel8.setLayout(new BorderLayout());
        panel8.add(cp1);
        panel8.add(new JLabel("    "), BorderLayout.EAST);
        panel8.add(new JLabel("    "), BorderLayout.NORTH);
        panel8.add(new JLabel("    "), BorderLayout.SOUTH);
        panel7.setLayout(new BorderLayout());
        panel7.add(uns1);
        cp1.setPreferredSize(new Dimension(40, 10));
        panel7.add(panel8, BorderLayout.EAST);
        panel2.add(panel5, BorderLayout.NORTH);
        panel2.add(panel6, BorderLayout.SOUTH);
        panel3.setLayout(new BorderLayout());
        panel3.setBackground(new java.awt.Color(101, 113, 132));

        //JFrame
        fr.setIconImage(icon1.getImage());
        fr.setLayout(new BorderLayout());
        fr.add(panel2, BorderLayout.NORTH);
        fr.add(panel, BorderLayout.WEST);
        fr.add(h1, BorderLayout.CENTER);
        fr.setSize(1280, 720);
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new MainMenu();
        });
    }
}
