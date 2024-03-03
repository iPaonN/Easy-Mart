package UI;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Product extends JPanel{
    private JFrame Product;
    private JPanel panelsubmain;
    
    public Product(){
        
        //Create
        Product = new JFrame("Product");
        panelsubmain = new JPanel();
        
        //Panelmain 
        this.setLayout(new BorderLayout());
        this.add(panelsubmain);
        this.setLayout(new BorderLayout());
        this.add(panelsubmain);
        this.setBorder(new LineBorder(new Color(101, 113, 132), 25));
        
        //Panelsubmain
        panelsubmain.setBorder(new LineBorder(new Color(69, 104, 159), 5));
        panelsubmain.setBackground(Color.WHITE);
        
        //Product
        Product.add(this);
        Product.setSize(1280, 720);
        Product.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Product.setVisible(false);
    }
    public static void main(String[] args) {
        new Product();
    }
}
