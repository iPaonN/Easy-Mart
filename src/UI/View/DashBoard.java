
package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class DashBoard extends JPanel{
    private JFrame mainf;
    private JPanel pmain, psubmain, pnorth, pcenter;
    private JPanel pempty1, pempty2;
    private JLabel jdashboard;
    private SubDashBoard_1 sdb1;
    private SubDashBoard_2 sdb2;
    private SubDashBoard_3 sdb3;
    private IncomeCompareGraph icg1;
    private IncomeGraph ig1;
    private TopProductGraph tpg1;
    public DashBoard(){
        icg1 = new IncomeCompareGraph();
        ig1 = new IncomeGraph();
        tpg1 = new TopProductGraph();
        sdb1 = new SubDashBoard_1();
        sdb2 = new SubDashBoard_2();
        sdb3 = new SubDashBoard_3();
        mainf = new JFrame();
        pmain = new JPanel();
        psubmain = new JPanel();
        pnorth = new JPanel();
        pcenter = new JPanel();
        pempty1 = new JPanel();
        pempty2 = new JPanel();
        jdashboard = new JLabel("DASH BOARD");
        jdashboard.setHorizontalAlignment(SwingConstants.CENTER);
        
        //SetLayout
        this.setLayout(new BorderLayout());
        pmain.setLayout(new BorderLayout());
        psubmain.setLayout(new BorderLayout());
        pnorth.setLayout(new BorderLayout());
        pcenter.setLayout(new BorderLayout());
        pempty1.setLayout(new GridLayout(1, 3));
        pempty2.setLayout(new GridLayout(1, 3));
        
        //SetBackGround
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(new Color(101, 113, 132), 25));
        psubmain.setBorder(new LineBorder(new Color(69, 104, 159), 7));
        pmain.setBorder(new LineBorder(Color.WHITE, 25));
        pmain.setBackground(Color.WHITE);
        psubmain.setBackground(Color.WHITE);
        pempty1.setBackground(Color.WHITE);
        pempty2.setBackground(Color.WHITE);
        pnorth.setBackground(Color.WHITE);
        pcenter.setBackground(Color.WHITE);
        
        //SetFont
        jdashboard.setFont(new Font("Aria", Font.BOLD, 40));
        jdashboard.setForeground(new Color(69, 104, 159));
        
        //Pmain
        pmain.add(pnorth, BorderLayout.NORTH);
        pmain.add(pcenter);
        
        //Pcenter
        pcenter.add(pempty1);
        pempty1.add(icg1);
        pempty1.add(ig1);
        pempty1.add(tpg1);
        
        pempty2.setPreferredSize(new Dimension(200, 150));
        pcenter.add(pempty2, BorderLayout.SOUTH); 
        pempty2.add(sdb3);
        pempty2.add(sdb1);
        pempty2.add(sdb2);
        
        //Pnorth
        pnorth.add(jdashboard);
            
        //JFrame
        psubmain.add(pmain);
        this.add(psubmain);
        mainf.add(this);
        mainf.setSize(1280, 720);
        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainf.setLocationRelativeTo(null);
        mainf.setVisible(false);
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

    public JPanel getPsubmain() {
        return psubmain;
    }

    public void setPsubmain(JPanel psubmain) {
        this.psubmain = psubmain;
    }

    public JPanel getPnorth() {
        return pnorth;
    }

    public void setPnorth(JPanel pnorth) {
        this.pnorth = pnorth;
    }

    public JPanel getPcenter() {
        return pcenter;
    }

    public void setPcenter(JPanel pcenter) {
        this.pcenter = pcenter;
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

    public JLabel getJdashboard() {
        return jdashboard;
    }

    public void setJdashboard(JLabel jdashboard) {
        this.jdashboard = jdashboard;
    }

    public SubDashBoard_1 getSdb1() {
        return sdb1;
    }

    public void setSdb1(SubDashBoard_1 sdb1) {
        this.sdb1 = sdb1;
    }

    public SubDashBoard_2 getSdb2() {
        return sdb2;
    }

    public void setSdb2(SubDashBoard_2 sdb2) {
        this.sdb2 = sdb2;
    }

    public SubDashBoard_3 getSdb3() {
        return sdb3;
    }

    public void setSdb3(SubDashBoard_3 sdb3) {
        this.sdb3 = sdb3;
    }

    public IncomeCompareGraph getIcg1() {
        return icg1;
    }

    public void setIcg1(IncomeCompareGraph icg1) {
        this.icg1 = icg1;
    }

    public IncomeGraph getIg1() {
        return ig1;
    }

    public void setIg1(IncomeGraph ig1) {
        this.ig1 = ig1;
    }

    public TopProductGraph getTpg1() {
        return tpg1;
    }

    public void setTpg1(TopProductGraph tpg1) {
        this.tpg1 = tpg1;
    }
    
    
}
