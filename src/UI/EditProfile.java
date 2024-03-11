package  UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class EditProfile {
    
    private JFrame mainf;
    private JPanel pnorth, pcenter, psouth, pincenter, pmain, pinmain;
    private JPanel pempty1, pempty2, pempty3;
    private JLabel jeditprofile, jfirstname, jlastname, jusername;
    private JTextField tffirstname, tflastname, tfusername;
    private JButton bsave;
    private HalfCircle hcp1;
    private ImageIcon i1, i2;
    public EditProfile(){
        
        //Create
        i1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        hcp1 = new HalfCircle();
        hcp1.LoadImage("src/UI/Image/3.jpg");
        mainf = new JFrame("EditProfile");
        pmain = new JPanel();
        pinmain = new JPanel();
        pnorth = new JPanel();
        pcenter = new JPanel();
        pincenter = new JPanel();
        psouth = new JPanel();
        pempty1 = new JPanel();
        pempty2 = new JPanel();
        pempty3 = new JPanel();
        jeditprofile = new JLabel("Edit Profile");
        jfirstname = new JLabel("First Name");
        jlastname = new JLabel("Last Name");
        jusername = new JLabel("Username");
        tffirstname = new JTextField();
        tflastname = new JTextField();
        tfusername = new JTextField();
        bsave = new JButton("  SAVE  ");
        
        //SetLayout
        mainf.setLayout(new BorderLayout());
        pmain.setLayout(new BorderLayout());
        pinmain.setLayout(new BorderLayout());
        pnorth.setLayout(new BorderLayout());
        pcenter.setLayout(new GridLayout(2, 0));
        pincenter.setLayout(new BorderLayout());
        psouth.setLayout(new BorderLayout());
        pempty1.setLayout(new BorderLayout());
        pempty2.setLayout(new GridLayout(10, 0));
        pempty3.setLayout(new BorderLayout());
        
        //SetBackGround
        mainf.setBackground(new Color(69, 104, 159));
        pmain.setBackground(new Color(69, 104, 159));
        pmain.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        pinmain.setBackground(new Color(69, 104, 159));
        pinmain.setBorder(new LineBorder(new Color(69, 104, 159), 15));
        pnorth.setBackground(new Color(69, 104, 159));
        pcenter.setBackground(new Color(69, 104, 159));
        pincenter.setBackground(new Color(69, 104, 159));
        psouth.setBackground(new Color(69, 104, 159));
        pempty1.setBackground(new Color(69, 104, 159));
        pempty2.setBackground(new Color(69, 104, 159));
        pempty3.setBackground(new Color(69, 104, 159));
        
        //SetFont
        jeditprofile.setFont(new Font("Arial", Font.BOLD, 30));
        jeditprofile.setForeground(Color.WHITE);
        jeditprofile.setBackground(new Color(69, 104, 159));
        jfirstname.setFont(new Font("Arial", Font.BOLD, 16));
        jfirstname.setForeground(Color.WHITE);
        jfirstname.setBackground(new Color(69, 104, 159));
        jlastname.setFont(new Font("Arial", Font.BOLD, 16));
        jlastname.setForeground(Color.WHITE);
        jlastname.setBackground(new Color(69, 104, 159));
        jusername.setFont(new Font("Arial", Font.BOLD, 16));
        jusername.setForeground(Color.WHITE);
        jusername.setBackground(new Color(69, 104, 159));
        
        tffirstname.setFont(new Font("Arial", Font.BOLD, 14));
        tffirstname.setForeground(Color.WHITE);
        tffirstname.setBackground(new Color(69, 104, 159));
        tffirstname.setBorder(new LineBorder(Color.WHITE, 2));
        tflastname.setFont(new Font("Arial", Font.BOLD, 14));
        tflastname.setForeground(Color.WHITE);
        tflastname.setBackground(new Color(69, 104, 159));
        tflastname.setBorder(new LineBorder(Color.WHITE, 2));
        tfusername.setFont(new Font("Arial", Font.BOLD, 14));
        tfusername.setForeground(Color.WHITE);
        tfusername.setBackground(new Color(69, 104, 159));
        tfusername.setBorder(new LineBorder(Color.WHITE, 2));
        
        bsave.setFont(new Font("Arial", Font.BOLD, 16));
        bsave.setForeground(new Color(69, 104, 159));
        bsave.setBackground(Color.WHITE);
        
        //Pinmain
        pinmain.add(pnorth, BorderLayout.NORTH);
        pinmain.add(pcenter, BorderLayout.CENTER);
        pinmain.add(psouth, BorderLayout.SOUTH);
        
        //Pnorth
        pnorth.add(jeditprofile);
        jeditprofile.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Pcenter
        pcenter.add(pempty1);
        pempty1.add(hcp1, BorderLayout.CENTER);
        pempty1.add(new JLabel("    "), BorderLayout.EAST);
        pempty1.add(new JLabel("    "), BorderLayout.WEST);
        
        pcenter.add(pempty2);
        pempty2.add(jusername);
        jusername.setHorizontalAlignment(SwingConstants.CENTER);
        tfusername.setHorizontalAlignment(SwingConstants.CENTER);
        pempty2.add(tfusername);
        pempty2.add(new JLabel());
        jfirstname.setHorizontalAlignment(SwingConstants.CENTER);
        tffirstname.setHorizontalAlignment(SwingConstants.CENTER);
        pempty2.add(jfirstname);
        pempty2.add(tffirstname);
        pempty2.add(new JLabel());
        jlastname.setHorizontalAlignment(SwingConstants.CENTER);
        tflastname.setHorizontalAlignment(SwingConstants.CENTER);
        pempty2.add(jlastname);
        pempty2.add(tflastname);
        pempty2.add(new JLabel());
        pempty2.add(new JLabel());
        
        //Psouth
        psouth.add(bsave, BorderLayout.EAST);
        
        //JFrame
        pmain.add(pinmain);
        mainf.setIconImage(i2.getImage());
        mainf.add(pmain);
        mainf.setSize(300, 600);
        mainf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainf.setVisible(true);
    }
    public static void main(String[] args) {
        new EditProfile();
    }
}
