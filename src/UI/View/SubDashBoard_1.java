
package UI.View;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class SubDashBoard_1 extends JPanel{
    private JFrame mainf;
    private JPanel pmain, pempty1;
    private JLabel jincome, jprice;
    private JButton bday, bweek, bYear;
    public SubDashBoard_1(){
        
        //Create
        mainf = new JFrame();
        pmain = new JPanel();
        pempty1 = new JPanel();
        jincome = new JLabel("Income");
        jprice = new JLabel("0฿");
        bday = new JButton("Day");
        bweek = new JButton("Week");
        bYear = new JButton("Year");
        
        //SetLayout
        this.setLayout(new BorderLayout());
        pmain.setLayout(new GridLayout(5,0));
        pempty1.setLayout(new GridLayout(1,3));
        
        //SetBackGround
        this.setBackground(Color.WHITE);
        pmain.setBackground(Color.WHITE);
        mainf.setBackground(Color.WHITE);
        pempty1.setBackground(Color.WHITE);
        
        //SetFont
        jincome.setFont(new Font("Aria", Font.BOLD, 20));
        jincome.setForeground(new Color(69, 104, 159));
        jprice.setFont(new Font("Aria", Font.BOLD, 20));
        jprice.setForeground(new Color(69, 104, 159));
        
        bday.setFont(new Font("Aria", Font.BOLD, 18));
        bday.setForeground(new Color(69, 104, 159));
        bday.setBackground(Color.WHITE);
        bday.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        bweek.setFont(new Font("Aria", Font.BOLD, 18));
        bweek.setForeground(new Color(69, 104, 159));
        bweek.setBackground(Color.WHITE);
        bweek.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        bYear.setFont(new Font("Aria", Font.BOLD, 18));
        bYear.setForeground(new Color(69, 104, 159));
        bYear.setBackground(Color.WHITE);
        bYear.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        
        //Pmain
        pmain.add(jincome);
        jincome.setHorizontalAlignment(SwingConstants.CENTER);
        pmain.add(new JLabel());
        pmain.add(jprice);
        jprice.setHorizontalAlignment(SwingConstants.CENTER);
        pmain.add(new JLabel());
        pmain.add(pempty1);
        
        //Pempty1
        pempty1.add(bday);
        pempty1.add(bweek);
        pempty1.add(bYear);
        
        this.add(pmain);
        pmain.setBorder(new LineBorder(Color.WHITE, 15));
        this.setBorder(new LineBorder(new Color(69, 104, 159), 5));
        
        
        //JFrame
        mainf.add(this);
        mainf.setSize(320, 220);
        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainf.setVisible(false);
        
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new SubDashBoard_1();
        });;
    }
}
