
package UI.View;

import My_sql.ProjectData.*;
import UI.Controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SubCashier extends JPanel /*implements ActionListener */{
    private Product product;
    private CashierController cashiercontroller;
    private JFrame mainf;
    private JPanel psub, psubnorth, psubcenter, psubsouth, pImage, btnPanel;
    private JPanel pempty1, pempty2, pempty3, pempty4, pempty5, pempty6;
    private JLabel Jproduct, Jnameproduct, Jtype, Jnametype, Jamount, Jnumamount, Jprice, Jnumprice;
    private JLabel Jempty1, Jempty2, Jempty3, Jempty4, Jempty5, Jempty6;
    private JButton plus, minus;
    private ImageIcon i1, i2;
    private String username, projectname;

    public SubCashier(String username, String projectname) {
        this.username = username;
        this.projectname = projectname;

        //Create
        i1 = new ImageIcon("src/UI/Image/eweweewew.jpg");
        i2 = new ImageIcon(i1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        mainf = new JFrame("SubProduct");
        Jnameproduct = new JLabel("......");
        Jproduct = new JLabel("Product Name : "+Jnameproduct.getText());
        Jnametype = new JLabel("......");
        Jtype = new JLabel("Type : "+Jnametype.getText());
        Jnumamount = new JLabel("......");
        Jamount = new JLabel("Amount : "+Jnumamount.getText());
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
        btnPanel = new JPanel();
        plus = new JButton("+");
        minus = new JButton("-");

        //Psubnorth
        psubnorth.setLayout(new GridLayout(2, 1));
        Jproduct.setHorizontalAlignment(SwingConstants.LEFT);
        psubnorth.add(pempty1);
        psubnorth.add(pempty2);
        pempty2.setLayout(new BorderLayout());
        pempty2.add(Jempty3, BorderLayout.WEST);
        pempty2.add(Jproduct, BorderLayout.CENTER);

        //Psubsouth
        psubsouth.setLayout(new GridLayout(4, 4));
        psubsouth.add(pempty3);
        psubsouth.add(pempty4);
        psubsouth.add(Jempty1);
        psubsouth.add(Jempty2);
        psubsouth.add(pempty5);
        psubsouth.add(pempty6);
        pempty3.setLayout(new BorderLayout());
        pempty4.setLayout(new BorderLayout());
        pempty5.setLayout(new BorderLayout());
        pempty6.setLayout(new BorderLayout());
        pempty3.add(Jempty4, BorderLayout.WEST);
        pempty3.add(Jtype);
        pempty4.add(Jamount);
        pempty5.add(Jempty5, BorderLayout.WEST);
        pempty5.add(Jprice);
        pempty6.add(Jempty6, BorderLayout.EAST);
        plus.setFocusPainted(false);
        minus.setFocusPainted(false);
        btnPanel.add(plus);
        btnPanel.add(minus);
        btnPanel.setBackground(new Color(69, 104, 159));
        pempty6.add(btnPanel);
        
        //SetBackground
        psubnorth.setBackground(new Color(69, 104, 159));
        psubcenter.setBackground(new Color(69, 104, 159));
        psubsouth.setBackground(new Color(69, 104, 159));
        pImage.setBackground(Color.WHITE);
        pImage.setPreferredSize(new Dimension(160,120));
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
        Jnametype.setFont(new Font("Aria", Font.PLAIN, 13));
        Jnametype.setForeground(Color.WHITE);
        Jtype.setFont(new Font("Aria", Font.BOLD, 14));
        Jtype.setForeground(Color.WHITE);
        Jnumamount.setFont(new Font("Aria", Font.PLAIN, 13));
        Jnumamount.setForeground(Color.WHITE);
        Jamount.setFont(new Font("Aria", Font.BOLD, 14));
        Jamount.setForeground(Color.WHITE);
        Jnumprice.setFont(new Font("Aria", Font.PLAIN, 13));
        Jnumprice.setForeground(Color.WHITE);
        Jprice.setFont(new Font("Aria", Font.BOLD, 14));
        Jprice.setForeground(Color.WHITE);
        plus.setFont(new Font("Aria", Font.BOLD, 13));
        plus.setForeground(new Color(69, 104, 159));
        plus.setBackground(Color.WHITE);
        minus.setFont(new Font("Aria", Font.BOLD, 13));
        minus.setForeground(new Color(69, 104, 159));
        minus.setBackground(Color.WHITE);
        
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
    
    public SubCashier(Product product, String username, String projectname){
        this(username, projectname);
        this.product = product;
        this.setAllData(product.getName(), product.getType(), product.getQuantity(), product.getPrice());
        Blob blob = product.getImage();
        try {
           byte[] imageData = blob.getBytes(1, (int) blob.length());

        Image image = ImageIO.read(new ByteArrayInputStream(imageData));
        this.getpImage().add(new JLabel(new ImageIcon(image))); 
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.repaint();
        this.revalidate();
    
    }

    public void setJnameproduct(String productName) {
        Jnameproduct.setText(productName);
        Jproduct.setText("Product Name : "+Jnameproduct.getText());
    }
    
    public void setJnametype(String type) {
        Jnametype.setText(type);
        Jtype.setText("Type : "+Jnametype.getText());
    }
    
    public void setJnumamount(int amount) {
        Jnumamount.setText(String.valueOf(amount));
        Jamount.setText("Amount : "+Jnumamount.getText());
    }
    
    public void setJnumprice(double price) {
        Jnumprice.setText(String.valueOf(price));
        Jprice.setText("Price : "+Jnumprice.getText());
    }
    
    public void setAllData(String productName, String type, int amount, double price) {
        setJnameproduct(productName);
        setJnametype(type);
        setJnumamount(amount);
        setJnumprice(price);
    }
    
    public void setNewProduct(Product np){
        this.setProduct(np);
        this.setJnameproduct(np.getName());
        this.setJnumamount(np.getQuantity());
        this.setJnametype(np.getType());
        this.setJnumprice(np.getWeight());
        Blob blob = np.getImage();
        try {
           byte[] imageData = blob.getBytes(1, (int) blob.length());

        Image image = ImageIO.read(new ByteArrayInputStream(imageData));
        this.getpImage().add(new JLabel(new ImageIcon(image))); 
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.repaint();
        this.revalidate();
    }
    
    public JFrame getMainf() {
        return mainf;
    }

    public JPanel getPsub() {
        return psub;
    }

    public JPanel getPsubnorth() {
        return psubnorth;
    }

    public JPanel getPsubcenter() {
        return psubcenter;
    }

    public JPanel getPsubsouth() {
        return psubsouth;
    }

    public JPanel getpImage() {
        return pImage;
    }

    public JPanel getBtnPanel() {
        return btnPanel;
    }

    public JPanel getPempty1() {
        return pempty1;
    }

    public JPanel getPempty2() {
        return pempty2;
    }

    public JPanel getPempty3() {
        return pempty3;
    }

    public JPanel getPempty4() {
        return pempty4;
    }

    public JPanel getPempty5() {
        return pempty5;
    }

    public JPanel getPempty6() {
        return pempty6;
    }

    public JLabel getJproduct() {
        return Jproduct;
    }

    public JLabel getJnameproduct() {
        return Jnameproduct;
    }

    public JLabel getJtype() {
        return Jtype;
    }

    public JLabel getJnametype() {
        return Jnametype;
    }

    public JLabel getJamount() {
        return Jamount;
    }

    public JLabel getJnumamount() {
        return Jnumamount;
    }

    public JLabel getJprice() {
        return Jprice;
    }

    public JLabel getJnumprice() {
        return Jnumprice;
    }

    public JLabel getJempty1() {
        return Jempty1;
    }

    public JLabel getJempty2() {
        return Jempty2;
    }

    public JLabel getJempty3() {
        return Jempty3;
    }

    public JLabel getJempty4() {
        return Jempty4;
    }

    public JLabel getJempty5() {
        return Jempty5;
    }

    public JLabel getJempty6() {
        return Jempty6;
    }

    public JButton getPlus() {
        return plus;
    }

    public JButton getMinus() {
        return minus;
    }

    public ImageIcon getI1() {
        return i1;
    }

    public ImageIcon getI2() {
        return i2;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public Product getProduct() {
        return product;
    }

//    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        SwingUtilities.invokeLater(() -> {
//            new SubCashier();
//        });
//    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource().equals(plus)){
//            new AddAmount();
//        }
//        else if(e.getSource().equals(minus)){
//            new AddAmount();
//        }
//    }
}