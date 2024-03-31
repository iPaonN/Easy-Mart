package UI.Controller;

import My_sql.My_sql;
import My_sql.ProjectData.DoProjectData;
import My_sql.ProjectData.Product;
import UI.Model.StockProductModel;
import UI.View.CreateProduct;
import UI.View.CreateType;
import UI.View.StockProduct;
import UI.View.SubProduct;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class StockProductController implements ActionListener{
    private String username, projectname, schema;
    private StockProduct view;
    private DoProjectData promanager;
    private StockProductModel model;
    private CreateProduct create;
    private CreateType newtype;
    private SubProduct subproduct;
    private File pimage;
    
    public StockProductController(String username, String projectname){
        this.username = username;
        this.projectname = projectname;
        this.schema = this.projectname;
        this.promanager = new DoProjectData();
        view = new StockProduct();
        model = new StockProductModel(this.username, this.projectname);
//        model.SetProductdata(1, "productname", 1, 15, 1, 3);
//        model.SetProductdata(2, "ABC", 1, 300, 1, 5);
//        model.SetProductdata(3, "Third", 1, 499, 1, 8);
//        promanager.set_product(schema, 1, "Test1", "Food", 100, 10, 5, null, this.username);
//        displaydata();
        //test
        //Add event
        this.showProduct(promanager.getAll_product(this.projectname));
        System.out.println(view.getCreate().getText());
        view.getCreate().addActionListener(this);
        
    }
    
    public StockProduct getView() {
        return view;
    }

    public void setView(StockProduct view) {
        this.view = view;
    }
    
//    public ResultSet GetAllData() {
//        My_sql sql = new My_sql();
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            sql.set_Schema(this.schema);
//            sql.connect();
//            conn = sql.get_Connection();
//            String query = "SELECT product_name, type_id, price, quantity FROM product";
//            stmt = conn.prepareStatement(query);
//            rs = stmt.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return rs;
//    }
//    
//    public void displaydata() {
//        ResultSet rs = GetAllData();
//        try {
//            while (rs.next()) {
//                String product_name = rs.getString("product_name");
//                String type_id = rs.getString("type_id");
//                int amount = rs.getInt("quantity");
//                Double price =  rs.getDouble("price");
//                subproduct = new SubProduct();
//                
//                subproduct.setAllData(product_name, type_id, amount, price);
//                view.getSubPanel().add(subproduct);
//                view.getSubPanel().revalidate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
//  
    public void showProduct(ArrayList<Product> productlist){
        for (Product p: productlist){
            SubProductController sc = new SubProductController(this.username, this.projectname, p);
            view.getSubPanel().add(sc.getSub());
        }
        view.getSubPanel().repaint();
        view.getSubPanel().revalidate();
    }
    public boolean isDouble(String str) { 
    try {  
        Double.parseDouble(str);  
        return true;
        }catch(NumberFormatException e){  
            return false;  
        }  
    }
    public boolean isInt(String str) { 
    try {  
        Integer.parseInt(str);  
        return true;
        }catch(NumberFormatException e){  
            return false;  
        }  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getCreate())){
            create = new CreateProduct();
            for (String t: promanager.getAll_Type(this.projectname)){
                create.getJcbtype().addItem(t);
            }
            create.getJcbtype().repaint();
            create.getJcbtype().revalidate();
            pimage = null;
            create.getJnew().addActionListener(this);
            create.getJaddpic().addActionListener(this);
            create.getJsave().addActionListener(this);
        }
        else if (e.getSource().equals(create.getJsave())){
            if(create.getTfproduct().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Plese Input Your Product Name.");
            }
            else if(model.checkCanUse(create.getTfproduct().getText()) == false){
                JOptionPane.showMessageDialog(null, "Product Name must have only Digit or Letter.");
                create.getTfproduct().setText("");
            }
            else if(model.checkProductName(create.getTfproduct().getText()) == true){
                JOptionPane.showMessageDialog(null, "This Product Name is already used.");
                create.getTfproduct().setText("");
            }
            else if(create.getTfprice().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Plese Input Price.");
            }
            else if(this.isDouble(create.getTfprice().getText()) == false){
                JOptionPane.showMessageDialog(null, "Price must be Double.");
                    create.getTfID().setText("");
            }
            else if(create.getTfweight().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Plese Input Weight.");
            }
            else if(this.isDouble(create.getTfweight().getText()) == false){
                JOptionPane.showMessageDialog(null, "Weight must be Double.");
                    create.getTfID().setText("");
            }
            else if(create.getTfamount().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Plese Input Amount.");
            }
            else if(this.isInt(create.getTfamount().getText()) == false){
                JOptionPane.showMessageDialog(null, "Amount must be Integer.");
                    create.getTfID().setText("");
            }
            else if(create.getTfID().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Plese Input Your Product Name.");
            }
            else if(this.isInt(create.getTfID().getText()) == false){
                JOptionPane.showMessageDialog(null, "ID must be Integer.");
                create.getTfID().setText("");
            }
            else if(model.checkProductID(Integer.parseInt(create.getTfID().getText())) == true){
                JOptionPane.showMessageDialog(null, "This Id is already used.");
                create.getTfID().setText("");
            }
            else if(pimage == null){
                JOptionPane.showMessageDialog(null, "Please Input Image");
            }
            else{
                promanager.set_product(this.projectname, Integer.parseInt(create.getTfID().getText()), create.getTfproduct().getText(), (String)create.getJcbtype().getSelectedItem(), Double.parseDouble(create.getTfprice().getText()), Double.parseDouble(create.getTfweight().getText()), Integer.parseInt(create.getTfamount().getText()), pimage, username);
                create.getMainf().dispose();
                view.getSubPanel().removeAll();
                this.showProduct(promanager.getAll_product(this.projectname));
                view.getSubPanel().revalidate();
                view.getSubPanel().repaint();
                
            }
        }
        else if (e.getSource().equals(create.getJaddpic())){
            JFileChooser fileChooser = new JFileChooser();
        
            // Optionally, restrict file types to images
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
            fileChooser.setFileFilter(filter);
        
            int returnValue = fileChooser.showOpenDialog(null);
        
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                 BufferedImage image = ImageIO.read(selectedFile);
                    pimage = selectedFile;
                    create.getPnorthinleft().add(new JLabel(new ImageIcon(image)));
                    create.getPnorthinleft().revalidate();
                    create.getPnorthinleft().repaint();
                    
                 } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else{
            pimage = null;
            }
        }
        else if (e.getSource().equals(create.getJnew())){
            newtype = new CreateType();
            newtype.getEnterBtn().addActionListener(this);
        }
        else if(e.getSource().equals(newtype.getEnterBtn())){
            if(newtype.getTypeTF().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please input type");
            }
            else if(model.checkType(newtype.getTypeTF().getText()) == false){
                JOptionPane.showMessageDialog(null, "Type must be only letter");
                newtype.getTypeTF().setText("");
            }
            else if(promanager.getAll_Type(this.projectname).contains(newtype.getTypeTF().getText()) == true){
                JOptionPane.showMessageDialog(null, "This Type is already added");
                newtype.getFrame().dispose();
            }
            else{
                create.getJcbtype().addItem(newtype.getTypeTF().getText());
                newtype.getFrame().dispose();
                create.getJcbtype().setSelectedItem(newtype.getTypeTF().getText());
                create.getJcbtype().repaint();
                create.getJcbtype().revalidate();
                
            }
        }
        
    }
    
}
