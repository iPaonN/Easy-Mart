/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.Controller;

import My_sql.ProjectData.Product;
import UI.View.SubProduct;
import UI.View.ViewProduct;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class SubProductController {
    private String username, projectname;
    private Product product;
    private SubProduct sub;
    private ViewProduct view;

    public SubProductController(String username, String projectname, Product product) {
        this.username = username;
        this.projectname = projectname;
        this.product = product;
        
        sub = new SubProduct();
        sub.setJnameproduct(product.getName());
        sub.setJnametype(product.getType());
        sub.setJnumamount(product.getQuantity());
        sub.setJnumprice(product.getPrice());
        Blob blob = product.getImage();
        try {
           byte[] imageData = blob.getBytes(1, (int) blob.length());

        Image image = ImageIO.read(new ByteArrayInputStream(imageData));
        sub.getpImage().add(new JLabel(new ImageIcon(image))); 
        }
        catch (Exception e){
            e.printStackTrace();
        }
        sub.repaint();
        sub.revalidate();
        
        
    }

    public SubProduct getSub() {
        return sub;
    }

    public void setSub(SubProduct sub) {
        this.sub = sub;
    }
        
    
}
