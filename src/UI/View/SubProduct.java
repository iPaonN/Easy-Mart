package UI.View;

import My_sql.ProjectData.Product;
import UI.Controller.ViewProductController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import UI.Controller.*;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import javax.imageio.ImageIO;

public class SubProduct extends JPanel {

    private JFrame mainf;
    private JPanel psub, psubnorth, psubcenter, psubsouth, pImage;
    private JPanel pempty1, pempty2, pempty3, pempty4, pempty5, pempty6;
    private JLabel Jproduct, Jnameproduct, Jtype, Jnametype, Jamount, Jnumamount, Jprice, Jnumprice;
    private JLabel Jempty1, Jempty2, Jempty3, Jempty4, Jempty5, Jempty6;
    private JButton bview;
    private ImageIcon i1, i2;
    private ViewProductController viewpd;
    private Product product;
    private String username, projectname;
    public SubProduct(String username, String projectname) {
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
        bview = new JButton("VIEW");

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
        pempty6.add(bview);
        
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
//        bview.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                viewpd = new ViewProductController(this, username, projectname);
//            }
//        });
        //Mainpanel
        this.setLayout(new BorderLayout());
        this.add(psubnorth, BorderLayout.NORTH);
        this.add(psubcenter, BorderLayout.CENTER);
        this.add(psubsouth, BorderLayout.SOUTH);
        this.setBackground(new Color(69, 104, 159));
        this.setBorder(new LineBorder(new Color(101, 113, 132), 5));
        this.setSize(300, 400);
    }
    public SubProduct(Product product, String username, String projectname){
        this(username, projectname);
        this.product = product;
        this.setJnameproduct(product.getName());
        this.setJnametype(product.getType());
        this.setJnumamount(product.getQuantity());
        this.setJnumprice(product.getPrice());
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

//    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        SwingUtilities.invokeLater(() -> {
//            new SubProduct();
//        });
//    }
    
    public JPanel psubcenter(){
        return psubcenter;
    }
    
    public JPanel getpImage(){
        return pImage;
    }
    
    public void setJnameproduct(String productName) {
        Jnameproduct.setText(productName);
        Jproduct.setText("Product Name : "+Jnameproduct.getText());
    }

    public String getJnameproduct() {
        return Jnameproduct.getText();
    }

    public void setJnametype(String type) {
        Jnametype.setText(type);
        Jtype.setText("Type : "+Jnametype.getText());
    }

    public String getJnametype() {
        return Jnametype.getText();
    }

    public void setJnumamount(int amount) {
        Jnumamount.setText(String.valueOf(amount));
        Jamount.setText("Amount : "+Jnumamount.getText());
    }

    public int getJnumamount() {
        return Integer.parseInt(Jnumamount.getText());
    }

    public void setJnumprice(double price) {
        Jnumprice.setText(String.valueOf(price));
        Jprice.setText("Price : "+Jnumprice.getText());
    }

    public double getJnumprice() {
        return Double.parseDouble(Jnumprice.getText());
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
    }

    public JButton getBview() {
        return bview;
    }

    public void setBview(JButton bview) {
        this.bview = bview;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
