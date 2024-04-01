package UI.Controller;

import My_sql.My_sql;
import My_sql.ProjectData.DoProjectData;
import My_sql.ProjectData.Product;
import UI.Model.ProductModel;
import UI.View.DeleteProduct;
import UI.View.SubProduct;
import UI.View.ViewProduct;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;


public class ViewProductController implements ActionListener {
    Statement stmt = null;
    Connection conn = null;
    private ViewProduct view; 
    private ProductModel model;
    private Product product;
    private DeleteProduct deleter;
    private String username, projectname;
    private DoProjectData promanager;
    private JPanel panel;
    
    
    public ViewProductController(JPanel panel, SubProduct sub, String username, String projectname) {
        view = new ViewProduct();
        product = sub.getProduct();
        this.panel = panel;
        this.username = username;
        this.projectname = projectname;
        promanager = new DoProjectData();
        
        view.setProductName(product.getName());
        view.setPricePerPiece(product.getPrice()+"");
        view.setType(product.getType());
        view.setAmount(product.getQuantity()+"");
        view.setWeight(product.getWeight()+"");
         Blob blob = product.getImage();
        try {
           byte[] imageData = blob.getBytes(1, (int) blob.length());

        Image image = ImageIO.read(new ByteArrayInputStream(imageData));
        view.getImageLabel().add(new JLabel(new ImageIcon(image)));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        view.getImageLabel().repaint();
        view.getImageLabel().revalidate();
        
        
        model = new ProductModel();
        
        view.getOKButton().addActionListener(this);
        view.getSetButton().addActionListener(this);
        view.getDeleteButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.getDeleteButton())){
            deleter = new DeleteProduct();
            deleter.getBn1().addActionListener(this);
        }
        else if(e.getSource().equals(view.getSetButton())){
            
        }
        else if(e.getSource().equals(deleter.getBn1())){
            if(deleter.getJt().getText().equals(product.getName())){
                promanager.remove_product(this.projectname, username, product.getName());
                deleter.getFr().dispose();
                view.getMainf().dispose();
                this.panel.removeAll();
                this.showProduct(promanager.getAll_product(this.projectname));
                this.panel.repaint();
                this.panel.revalidate();
            }
            else{
                JOptionPane.showMessageDialog(null, "Don't have "+product.getName());
            }
        }
    }
        public void showProduct(ArrayList<Product> productlist){
        for (Product p: productlist){
            SubProduct sub = new SubProduct(p, username, projectname);
            panel.add(sub);
            sub.getBview().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewProductController(panel, sub, username, projectname);
            }
        });;
        }
        panel.repaint();
        panel.revalidate();
    }
}
