
package UI.View;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class SubDashBoard_2 extends JPanel{
    private JFrame mainf;
    private JPanel pmain, pempty1;
    private JLabel jselling, jproduct;
    private JButton bday, bmonth, bYear;
    public SubDashBoard_2(){
        
        //Create
        mainf = new JFrame();
        pmain = new JPanel();
        pempty1 = new JPanel();
        jselling = new JLabel("Top Selling Product");
        jproduct = new JLabel("Coke");
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
        
        //SetFont
        jselling.setFont(new Font("Aria", Font.BOLD, 16));
        jselling.setForeground(new Color(69, 104, 159));
        jproduct.setFont(new Font("Aria", Font.BOLD, 16));
        jproduct.setForeground(new Color(69, 104, 159));
        
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
        pmain.add(jselling);
        jselling.setHorizontalAlignment(SwingConstants.CENTER);
        pmain.add(new JLabel());
        pmain.add(jproduct);
        jproduct.setHorizontalAlignment(SwingConstants.CENTER);
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
            new SubDashBoard_2();
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

    public JLabel getJselling() {
        return jselling;
    }

    public void setJselling(JLabel jselling) {
        this.jselling = jselling;
    }

    public JLabel getJproduct() {
        return jproduct;
    }

    public void setJproduct(JLabel jproduct) {
        this.jproduct = jproduct;
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

    public void setBmonth(JButton bmonth) {
        this.bmonth = bmonth;
    }

    public JButton getbYear() {
        return bYear;
    }

    public void setbYear(JButton bYear) {
        this.bYear = bYear;
    }
    
    
}
