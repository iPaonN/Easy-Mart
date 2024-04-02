
package UI.View;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class SubDashBoard_3 extends JPanel{
    private JFrame mainf;
    private JPanel pmain, pempty1, pempty2;
    private JLabel jcompare, jcompareprice, jincrease, jdecrease, jnormal, jcomapreicon;
    private JButton bday, bmonth, bYear;
    public SubDashBoard_3(){
        
        //Create
        mainf = new JFrame();
        pmain = new JPanel();
        pempty1 = new JPanel();
        pempty2 = new JPanel();
        jcomapreicon = new JLabel("");
        jincrease = new JLabel("▲");
        jnormal = new JLabel("▬");
        jdecrease = new JLabel("▼");
        jcompare = new JLabel("Compare Income");
        jcompareprice = new JLabel("1500฿");
        bday = new JButton("Day");
        bmonth = new JButton("Month");
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
        pempty2.setBackground(Color.WHITE);
        
        //SetFont
        jdecrease.setForeground(Color.RED.darker());
        jnormal.setForeground(Color.WHITE.darker());
        jincrease.setForeground(Color.GREEN.darker());
        jcompare.setFont(new Font("Aria", Font.BOLD, 16));
        jcompare.setForeground(new Color(69, 104, 159));
        jcompareprice.setFont(new Font("Aria", Font.BOLD, 16));
        jcompareprice.setForeground(new Color(69, 104, 159));
        
        bday.setFont(new Font("Aria", Font.BOLD, 14));
        bday.setForeground(new Color(69, 104, 159));
        bday.setBackground(Color.WHITE);
        bday.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        bmonth.setFont(new Font("Aria", Font.BOLD, 14));
        bmonth.setForeground(new Color(69, 104, 159));
        bmonth.setBackground(Color.WHITE);
        bmonth.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        bYear.setFont(new Font("Aria", Font.BOLD, 14));
        bYear.setForeground(new Color(69, 104, 159));
        bYear.setBackground(Color.WHITE);
        bYear.setBorder(new LineBorder(new Color(69, 104, 159), 3));
        
        //Pmain
        pmain.add(jcompare);
        jcompare.setHorizontalAlignment(SwingConstants.CENTER);
        pmain.add(new JLabel());
        pmain.add(pempty2);
        pempty2.add(jcompareprice);
        pempty2.add(jcomapreicon);
        jcompareprice.setHorizontalAlignment(SwingConstants.CENTER);
        pmain.add(new JLabel());
        pmain.add(pempty1);
        
        //Pempty1
        pempty1.add(bday);
        pempty1.add(bmonth);
        pempty1.add(bYear);
        
        this.add(pmain);
        pmain.setBorder(new LineBorder(Color.WHITE, 15));
        this.setBorder(new LineBorder(new Color(69, 104, 159), 2));
        
        
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
            new SubDashBoard_3();
        });
    }

    public JFrame getMainf() {
        return mainf;
    }

    public void setMainf(JFrame mainf) {
        this.mainf = mainf;
    }

    public JPanel getPmain() {
        return pmain;
    }

    public void setPmain(JPanel pmain) {
        this.pmain = pmain;
    }

    public JPanel getPempty1() {
        return pempty1;
    }

    public void setPempty1(JPanel pempty1) {
        this.pempty1 = pempty1;
    }

    public JPanel getPempty2() {
        return pempty2;
    }

    public void setPempty2(JPanel pempty2) {
        this.pempty2 = pempty2;
    }

    public JLabel getJcompare() {
        return jcompare;
    }

    public void setJcompare(JLabel jcompare) {
        this.jcompare = jcompare;
    }

    public JLabel getJcompareprice() {
        return jcompareprice;
    }

    public void setJcompareprice(JLabel jcompareprice) {
        this.jcompareprice = jcompareprice;
    }

    public JLabel getJincrease() {
        return jincrease;
    }

    public void setJincrease(JLabel jincrease) {
        this.jincrease = jincrease;
    }

    public JLabel getJdecrease() {
        return jdecrease;
    }

    public void setJdecrease(JLabel jdecrease) {
        this.jdecrease = jdecrease;
    }

    public JLabel getJnormal() {
        return jnormal;
    }

    public void setJnormal(JLabel jnormal) {
        this.jnormal = jnormal;
    }

    public JButton getBday() {
        return bday;
    }

    public void setBday(JButton bday) {
        this.bday = bday;
    }

    public JButton getBmonth() {
        return bmonth;
    }

    public void setBmonth(JButton bweek) {
        this.bmonth = bweek;
    }

    public JButton getbYear() {
        return bYear;
    }

    public void setbYear(JButton bYear) {
        this.bYear = bYear;
    }

    public JLabel getjcomapreicon() {
        return jcomapreicon;
    }

    public void setjcomapreicon(JLabel jcomapreicon) {
        this.jcomapreicon = jcomapreicon;
    }
    
    
}
