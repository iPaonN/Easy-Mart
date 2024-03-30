
package UI.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SubCashier extends JPanel {

    private JFrame mainf;
    private JPanel psub, psubnorth, psubcenter, psubsouth, pImage, allsubsouth;
    private JPanel pempty1, pempty2, pempty3, pempty4, pempty5, pempty6;
    private JLabel Jproduct, Jnameproduct, Jprice, Jnumprice;
    private JLabel Jempty1, Jempty2, Jempty3, Jempty4, Jempty5, Jempty6;
    private JButton bview;
    private ImageIcon i1, i2;

    public SubCashier() {
        //Create
        i1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        mainf = new JFrame("SubProduct");
        Jnameproduct = new JLabel("......");
        Jproduct = new JLabel("Product Name : "+Jnameproduct.getText());
        Jnumprice = new JLabel("......");
        Jprice = new JLabel("Price : "+Jnumprice.getText());
        Jempty1 = new JLabel();
        Jempty2 = new JLabel();
        Jempty3 = new JLabel("       ");
        Jempty4 = new JLabel("       ");
        Jempty5 = new JLabel("       ");
        Jempty6 = new JLabel("       ");
        psubnorth = new JPanel();
        psubcenter = new JPanel();
        psubsouth = new JPanel();
        pImage = new JPanel();
        pempty1 = new JPanel();
        pempty2 = new JPanel();
        pempty3 = new JPanel();
        pempty4 = new JPanel();
        pempty5 = new JPanel();
        pempty6 = new JPanel();
        allsubsouth = new JPanel();
        bview = new JButton("ADD");

        //Psubnorth
        psubnorth.setLayout(new GridLayout(2, 1));
        Jproduct.setHorizontalAlignment(SwingConstants.LEFT);
        psubnorth.add(pempty1);
        psubnorth.add(pempty2);
        pempty2.setLayout(new BorderLayout());
        pempty2.add(Jempty3, BorderLayout.WEST);
        pempty2.add(Jproduct, BorderLayout.CENTER);

        //Psubsouth
        psubsouth.setLayout(new BorderLayout());
        psubsouth.add(allsubsouth);
        psubsouth.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        allsubsouth.setLayout(new BorderLayout());
        allsubsouth.add(pempty3, BorderLayout.NORTH);
        allsubsouth.add(pempty5);
        pempty3.add(Jprice);
        pempty5.add(bview);
        pempty5.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        
        //SetBackground
        psubnorth.setBackground(new Color(69, 104, 159));
        psubcenter.setBackground(new Color(69, 104, 159));
        psubsouth.setBackground(new Color(69, 104, 159));
        pImage.setBackground(Color.WHITE);
        //pImage.setPreferredSize(new Dimension(160,120));
        pempty1.setBackground(new Color(69, 104, 159));
        pempty2.setBackground(new Color(69, 104, 159));
        pempty3.setBackground(new Color(69, 104, 159));
        pempty4.setBackground(new Color(69, 104, 159));
        pempty5.setBackground(new Color(69, 104, 159));
        pempty6.setBackground(new Color(69, 104, 159));
        
        //SetFont
        Jnameproduct.setFont(new Font("Aria", Font.PLAIN, 13));
        Jnameproduct.setForeground(Color.WHITE);
        Jproduct.setFont(new Font("Aria", Font.BOLD, 16));
        Jproduct.setForeground(Color.WHITE);
        Jnumprice.setFont(new Font("Aria", Font.PLAIN, 13));
        Jnumprice.setForeground(Color.WHITE);
        Jprice.setFont(new Font("Aria", Font.BOLD, 14));
        Jprice.setForeground(Color.WHITE);
        bview.setFont(new Font("Aria", Font.BOLD, 13));
        bview.setForeground(new Color(69, 104, 159));
        bview.setBackground(Color.WHITE);
        
        //Psubcenter
        psubcenter.setLayout(new BorderLayout());
        psubcenter.setBackground(new Color(69, 104, 159));
        psubcenter.setBorder(new LineBorder(new Color(69, 104, 159), 20));
        pImage.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        pImage.setLayout(new FlowLayout()); 
        psubcenter.add(pImage);
        
        //Mainpanel
        this.setLayout(new BorderLayout());
        this.add(psubnorth, BorderLayout.NORTH);
        this.add(psubcenter, BorderLayout.CENTER);
        this.add(psubsouth, BorderLayout.SOUTH);
        this.setBackground(new Color(69, 104, 159));
        this.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        this.setSize(300, 400);
    }
}