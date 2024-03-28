
package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class DashBoard extends JPanel{
    private JFrame mainf;
    private JPanel pmain, psubmain, pnorth, pcenter;
    private JLabel jdashboard;
    private SubDashBoard_1 sdb1;
    private SubDashBoard_2 sdb2;
    private SubDashBoard_3 sdb3;
    public DashBoard(){
        
        sdb1 = new SubDashBoard_1();
        sdb2 = new SubDashBoard_2();
        sdb3 = new SubDashBoard_3();
        mainf = new JFrame();
        pmain = new JPanel();
        psubmain = new JPanel();
        pnorth = new JPanel();
        pcenter = new JPanel();
        jdashboard = new JLabel("DASH BOARD");
        
        //SetLayout
        this.setLayout(new BorderLayout());
        pmain.setLayout(new BorderLayout());
        psubmain.setLayout(new BorderLayout());
        pnorth.setLayout(new BorderLayout());
        pcenter.setLayout(new GridLayout(2, 3));
        
        //SetBackGround
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(new Color(101, 113, 132), 25));
        psubmain.setBorder(new LineBorder(new Color(69, 104, 159), 7));
        pmain.setBorder(new LineBorder(Color.WHITE, 35));
        pmain.setBackground(Color.WHITE);
        psubmain.setBackground(Color.WHITE);
        pnorth.setBackground(Color.WHITE);
        pcenter.setBackground(Color.WHITE);
        
        //SetFont
        jdashboard.setFont(new Font("Aria", Font.BOLD, 40));
        jdashboard.setForeground(new Color(69, 104, 159));
        
        //Pmain
        pmain.add(pnorth, BorderLayout.NORTH);
        pmain.add(pcenter);
        
        //Pnorth
        pnorth.add(jdashboard);
        
        //Pcenter
        pcenter.add(new JLabel());
        pcenter.add(new JLabel());
        pcenter.add(new JLabel());
        pcenter.add(sdb1);
        pcenter.add(sdb2);
        pcenter.add(sdb3);
        
        //JFrame
        psubmain.add(pmain);
        this.add(psubmain);
        mainf.add(this);
        mainf.setSize(1280, 720);
        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainf.setVisible(false);
    }
    public static void main(String[] args) {
        new DashBoard();
    }
}
