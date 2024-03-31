package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Option extends JPanel {

    private JFrame mainf;
    private JPanel pinmain, pmain, pnorth, pcenter, peast, pincenternorth, pincentersouth;
    private JPanel pempty1, pempty2, pempty3, pempty4, pempty5, pempty6, pempty7, pempty8, pempty9, pempty10, pempty11, pempty12;
    private JLabel jeditproject, jprojectname, jconfirmprojectname, jdangerzone, jprojectremove, jtextremove, jprojecticon;
    private JTextField tfprojectname, tfconfirmprojectname;
    private JButton bsave1, bsave2, bdelete;
    private HalfCirclev2 hcv1;
    private ImageIcon i1, i2;
    
    public Option() {

        //Create
        i1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        hcv1 = new HalfCirclev2();
//        hcv1.LoadImage("src/UI/Image/3.jpg");
        mainf = new JFrame("Option");
        pinmain = new JPanel();
        pmain = new JPanel();
        pnorth = new JPanel();
        pincentersouth = new JPanel();
        pincenternorth = new JPanel();
        pcenter = new JPanel();
        peast = new JPanel();
        pempty1 = new JPanel();
        pempty2 = new JPanel();
        pempty3 = new JPanel();
        pempty4 = new JPanel();
        pempty5 = new JPanel();
        pempty6 = new JPanel();
        pempty7 = new JPanel();
        pempty8 = new JPanel();
        pempty9 = new JPanel();
        pempty10 = new JPanel();
        pempty11 = new JPanel();
        pempty12 = new JPanel();
        peast = new JPanel();
        peast = new JPanel();
        peast = new JPanel();
        peast = new JPanel();
        peast = new JPanel();
        jeditproject = new JLabel("Edit Project");
        jprojectname = new JLabel("Project Name");
        jconfirmprojectname = new JLabel("Confirm Name");
        jdangerzone = new JLabel("Danger Zone");
        jprojectremove = new JLabel("Project Removal");
        jtextremove = new JLabel("Before remove: ***you can't recover your project.***");
        jprojecticon = new JLabel("Project Icon");
        tfprojectname = new JTextField();
        tfconfirmprojectname = new JTextField();
        bsave1 = new JButton("  SAVE  ");
        bsave2 = new JButton("SAVE");
        bdelete = new JButton("  Delete  ");

        //SetLayout
        this.setLayout(new BorderLayout());
        pinmain.setLayout(new BorderLayout());
        pincentersouth.setLayout(new BorderLayout());
        pincenternorth.setLayout(new GridLayout(8, 0));
        pmain.setLayout(new BorderLayout());
        pnorth.setLayout(new BorderLayout());
        pcenter.setLayout(new GridLayout(2, 0));
        peast.setLayout(new BorderLayout());
        pempty1.setLayout(new BorderLayout());
        pempty2.setLayout(new BorderLayout());
        pempty3.setLayout(new BorderLayout());
        pempty4.setLayout(new BorderLayout());
        pempty5.setLayout(new BorderLayout());
        pempty6.setLayout(new BorderLayout());
        pempty7.setLayout(new GridLayout(4, 0));
        pempty8.setLayout(new BorderLayout());
        pempty9.setLayout(new BorderLayout());
        pempty10.setLayout(new BorderLayout());
        pempty11.setLayout(new BorderLayout());
        pempty12.setLayout(new BorderLayout());

        //SetBackGround
        this.setBorder(new LineBorder(new Color(101, 113, 132), 25));
        pmain.setBorder(new LineBorder(new Color(69, 104, 159), 5));
        pmain.setBackground(Color.WHITE);
        pinmain.setBackground(Color.WHITE);
        pinmain.setBorder(new LineBorder(Color.WHITE, 35));
        pnorth.setBackground(Color.WHITE);
        pcenter.setBackground(Color.WHITE);
        peast.setBackground(Color.WHITE);
        pincenternorth.setBackground(Color.WHITE);
        pincentersouth.setBackground(Color.WHITE);
        pempty1.setBackground(Color.WHITE);
        pempty2.setBackground(Color.WHITE);
        pempty3.setBackground(Color.WHITE);
        pempty4.setBackground(Color.WHITE);
        pempty5.setBackground(Color.WHITE);
        pempty6.setBackground(Color.WHITE);
        pempty7.setBackground(Color.WHITE);
        pempty8.setBackground(Color.WHITE);
        pempty9.setBackground(Color.WHITE);
        pempty10.setBorder(new LineBorder(Color.RED, 3));
        pempty10.setBackground(Color.WHITE);
        pempty11.setBackground(Color.WHITE);
        pempty11.setBorder(new LineBorder(Color.WHITE, 15));
        pempty12.setBackground(Color.WHITE);

        //SetFont
        jeditproject.setFont(new Font("Arial", Font.BOLD, 40));
        jeditproject.setForeground(new Color(69, 104, 159));
        jeditproject.setBackground(new Color(69, 104, 159));
        jprojectname.setFont(new Font("Arial", Font.BOLD, 16));
        jprojectname.setForeground(new Color(69, 104, 159));
        jprojectname.setBackground(new Color(69, 104, 159));
        jconfirmprojectname.setFont(new Font("Arial", Font.BOLD, 16));
        jconfirmprojectname.setForeground(new Color(69, 104, 159));
        jconfirmprojectname.setBackground(new Color(69, 104, 159));
        jdangerzone.setFont(new Font("Arial", Font.BOLD, 16));
        jdangerzone.setForeground(Color.RED);
        jdangerzone.setBackground(new Color(69, 104, 159));
        jprojectremove.setFont(new Font("Arial", Font.BOLD, 40));
        jprojectremove.setForeground(new Color(69, 104, 159));
        jprojectremove.setBackground(new Color(69, 104, 159));
        jtextremove.setFont(new Font("Arial", Font.BOLD, 16));
        jtextremove.setForeground(Color.RED);
        jtextremove.setBackground(new Color(69, 104, 159));
        jprojecticon.setFont(new Font("Arial", Font.BOLD, 40));
        jprojecticon.setForeground(new Color(69, 104, 159));
        jprojecticon.setBackground(new Color(69, 104, 159));

        tfprojectname.setFont(new Font("Arial", Font.BOLD, 14));
        tfprojectname.setForeground(new Color(69, 104, 159));
        tfprojectname.setBackground(Color.WHITE);
        tfprojectname.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        tfconfirmprojectname.setFont(new Font("Arial", Font.BOLD, 14));
        tfconfirmprojectname.setForeground(new Color(69, 104, 159));
        tfconfirmprojectname.setBackground(Color.WHITE);
        tfconfirmprojectname.setBorder(new LineBorder(new Color(69, 104, 159), 3));

        bsave1.setFont(new Font("Arial", Font.BOLD, 16));
        bsave1.setForeground(new Color(69, 104, 159));
        bsave1.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        bsave1.setBackground(Color.WHITE);
        bsave2.setFont(new Font("Arial", Font.BOLD, 16));
        bsave2.setForeground(new Color(69, 104, 159));
        bsave2.setBackground(Color.WHITE);
        bsave2.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        bdelete.setFont(new Font("Arial", Font.BOLD, 20));
        bdelete.setForeground(Color.RED);
        bdelete.setBackground(Color.WHITE);
        bdelete.setBorder(new LineBorder(Color.RED, 3));

        //Pinmain
        pinmain.add(pnorth, BorderLayout.NORTH);
        pinmain.add(pcenter, BorderLayout.CENTER);
        pinmain.add(peast, BorderLayout.EAST);

        //Pnorth
        pnorth.add(jeditproject, BorderLayout.WEST);
        pnorth.add(jprojecticon, BorderLayout.CENTER);
        jprojecticon.setHorizontalAlignment(SwingConstants.RIGHT);
        pnorth.add(new JLabel("                                "), BorderLayout.EAST);

        //Peast
        peast.setPreferredSize(new Dimension(500, 200));
        peast.add(hcv1);
        peast.add(new JLabel("                                                    "), BorderLayout.WEST);
        peast.add(pempty9, BorderLayout.NORTH);
        peast.add(new JLabel("                  "), BorderLayout.EAST);
        pempty7.setPreferredSize(new Dimension(200, 130));
        peast.add(pempty7, BorderLayout.SOUTH);
        pempty9.setPreferredSize(new Dimension(20, 20));
        pempty7.add(new Label());
        pempty7.add(pempty8);
        pempty8.add(bsave2);
        pempty8.add(new JLabel("                                                                        "), BorderLayout.WEST);
        pempty8.add(new JLabel("                                         "), BorderLayout.EAST);

        //PCenter
        pcenter.add(pincenternorth);
        pincenternorth.add(jprojectname);

        pincenternorth.add(pempty1);
        pempty1.add(tfprojectname);
        pempty1.add(new JLabel("                                                "), BorderLayout.EAST);

        pincenternorth.add(new JLabel());

        pincenternorth.add(jconfirmprojectname);

        pincenternorth.add(pempty2);
        pempty2.add(tfconfirmprojectname);
        pempty2.add(new JLabel("                                                 "), BorderLayout.EAST);

        pincenternorth.add(new JLabel());

        pincenternorth.add(pempty3);
        pempty3.add(bsave1, BorderLayout.WEST);

        pincenternorth.add(new JLabel());

        pcenter.add(pincentersouth);
        pincentersouth.add(jdangerzone, BorderLayout.NORTH);
        pincentersouth.add(pempty10);
        pempty10.add(pempty11);
        pempty11.add(jprojectremove, BorderLayout.NORTH);
        pempty11.add(jtextremove);
        pempty11.add(pempty12, BorderLayout.SOUTH);
        pempty12.add(bdelete, BorderLayout.WEST);

        //Product
        pmain.add(pinmain);
        this.add(pmain);
        mainf.add(this);
        mainf.setIconImage(i2.getImage());
        mainf.setSize(1280, 720);
        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainf.setLocationRelativeTo(null);
        mainf.setVisible(false);
    }
    
    public JButton getSaveButton(){
        return bsave1;
    }
    
    public JButton getSaveButton2(){
        return bsave2;
    }
    
    public HalfCirclev2 getProfileicon(){
        return hcv1;
    }
    
    public JTextField getTFprojectname(){
        return tfprojectname;
    }
    
    public JTextField getTFprojectnameC(){
        return tfconfirmprojectname;
    }
    
}

