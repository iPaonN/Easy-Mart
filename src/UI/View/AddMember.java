
package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class AddMember {
    private JFrame mainf;
    private JPanel poutmain, pmain, pempty1, pempty2, pempty3, pempty4, pempty5;
    private JLabel jalert, jemail, jrole, jAddmemeber;
    private JTextField tfemial;
    private JComboBox jcb1;
    private JButton badd;
    public AddMember(){
        mainf = new JFrame();
        pmain = new JPanel();
        poutmain = new JPanel();
        pempty1 = new JPanel();
        pempty2 = new JPanel();
        pempty3 = new JPanel();
        pempty4 = new JPanel();
        pempty5 = new JPanel();
        jalert = new JLabel("Dont do that!!!");
        jAddmemeber = new JLabel("Add Member");
        jAddmemeber.setHorizontalAlignment(SwingConstants.CENTER);
        jemail = new JLabel("Email");
        jrole = new JLabel("Role : ");
        jrole.setHorizontalAlignment(SwingConstants.RIGHT);
        tfemial = new JTextField();
        jcb1 = new JComboBox();
        jcb1.addItem("                   ");
        badd = new JButton("Add");
        
        //SetBackground
        pmain.setBackground(new Color(69, 104, 159));
        poutmain.setBackground(new Color(69, 104, 159));
        pmain.setBorder(new LineBorder(new Color(69, 104, 159), 15));
        poutmain.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        pempty1.setBackground(new Color(69, 104, 159));
        pempty2.setBackground(new Color(69, 104, 159));
        pempty3.setBackground(new Color(69, 104, 159));
        pempty4.setBackground(new Color(69, 104, 159));
        pempty5.setBackground(new Color(69, 104, 159));
        
        //SetLayout
        pempty1.setLayout(new BorderLayout());
        pempty3.setLayout(new BorderLayout());
        pempty4.setLayout(new BorderLayout());
        pempty5.setLayout(new BorderLayout());
        pempty2.setLayout(new GridLayout(6, 0));
        pmain.setLayout(new BorderLayout());
        poutmain.setLayout(new BorderLayout());
        
        //SetFont
        jAddmemeber.setFont(new Font("Aria", Font.BOLD, 25));
        jAddmemeber.setForeground(Color.WHITE);
        tfemial.setFont(new Font("Aria", Font.PLAIN, 14));
        tfemial.setForeground(Color.WHITE);
        tfemial.setBackground(new Color(69, 104, 159));
        tfemial.setBorder(new LineBorder(Color.WHITE, 2));
        jalert.setFont(new Font("Aria", Font.BOLD, 11));
        jalert.setForeground(new Color(250, 199, 16));
        jemail.setFont(new Font("Aria", Font.BOLD, 14));
        jemail.setForeground(Color.WHITE);
        jrole.setFont(new Font("Aria", Font.BOLD, 14));
        jrole.setForeground(Color.WHITE);
        badd.setFont(new Font("Aria", Font.BOLD, 14));
        badd.setBackground(new Color(69, 104, 159));
        badd.setForeground(new Color(69, 104, 159));
        
        //Pmain
        pmain.add(jAddmemeber, BorderLayout.NORTH);
        pmain.add(pempty2);
        
        pempty2.add(pempty3);
        pempty3.add(jemail, BorderLayout.WEST);
        
        pempty2.add(pempty1);
        
        pempty1.add(tfemial);
        
        pempty2.add(jalert);
        pempty2.add(pempty5);
        pempty2.add(new JLabel());
        pempty2.add(pempty4);
        pempty5.add(jrole, BorderLayout.WEST);
        pempty5.add(jcb1);
        pempty4.add(badd);
        pempty4.add(new JLabel("                                             "), BorderLayout.WEST);
        pempty4.add(new JLabel("                                             "), BorderLayout.EAST);
        
        //JFrame
        poutmain.add(pmain);
        mainf.add(poutmain);
        mainf.setSize(400, 250);
        mainf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainf.setVisible(true);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new AddMember();
        });
    }
}
