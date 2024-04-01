package UI.Controller;

import My_sql.My_sql;
import My_sql.ProjectData.Product;
import UI.Model.ProductModel;
import UI.View.SubProduct;
import UI.View.ViewProduct;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class ViewProductController implements ActionListener {
    Statement stmt = null;
    Connection conn = null;
    private ViewProduct view; 
    private ProductModel model;
    private Product product;
    
    
    public ViewProductController(SubProduct sub, String username, String projectname) {
        view = new ViewProduct();
        product = sub.getProduct();
        
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
        
        view.getSaveButton().addActionListener(this);
        view.getOKButton().addActionListener(this);
        view.getSetButton().addActionListener(this);
        view.getDeleteButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
