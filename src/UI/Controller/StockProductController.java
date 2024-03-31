package UI.Controller;

import My_sql.My_sql;
import My_sql.ProjectData.DoProjectData;
import UI.Model.StockProductModel;
import UI.View.CreateProduct;
import UI.View.CreateType;
import UI.View.StockProduct;
import UI.View.SubProduct;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class StockProductController implements ActionListener, FocusListener{
    private String username, projectname, schema;
    private StockProduct view;
    private DoProjectData promanager;
    private StockProductModel model;
    private CreateProduct create;
    private CreateType newtype;
    private SubProduct subproduct;
    
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
        System.out.println(view.getCreate().getText());
        view.getCreate().addActionListener(this);
        
    }
    
    public StockProduct getView() {
        return view;
    }

    public void setView(StockProduct view) {
        this.view = view;
    }
    
    public ResultSet GetAllData() {
        My_sql sql = new My_sql();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            sql.set_Schema(this.schema);
            sql.connect();
            conn = sql.get_Connection();
            String query = "SELECT product_name, type_id, price, quantity FROM product";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
    
    public void displaydata() {
        ResultSet rs = GetAllData();
        try {
            while (rs.next()) {
                String product_name = rs.getString("product_name");
                String type_id = rs.getString("type_id");
                int amount = rs.getInt("quantity");
                Double price =  rs.getDouble("price");
                subproduct = new SubProduct();
                
                subproduct.setAllData(product_name, type_id, amount, price);
                view.getSubPanel().add(subproduct);
                view.getSubPanel().revalidate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new StockProductController("Teetat", "Aun_OOP");
    }
//  
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
            create.getJsave().addActionListener(this);
            create.getTfproduct().addFocusListener(this);
            create.getTfprice().addFocusListener(this);
            create.getTfamount().addFocusListener(this);
            create.getTfweight().addFocusListener(this);
        }
        else if (e.getSource().equals(create.getJsave())){
            if(create.getTfproduct().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Plese Enter Your Product Name.");
            }
            else if(e.getSource().equals(create.getTfprice())){
                if(create.getTfprice().getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Plese Input Price.");
                }
            }
            else if(e.getSource().equals(create.getTfweight())){
                if(create.getTfweight().getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Plese Input Weight.");
                }
            }
            else if(e.getSource().equals(create.getTfamount())){
                if(create.getTfamount().getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Plese Input Amount.");
                }
            }
            else{
                System.out.println(model.checkProductName(create.getTfproduct().getText()));
            }
            }
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource().equals(create.getTfproduct())){
            if(create.getTfproduct().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Plese Enter Your Product Name.");
            }
            else if(model.checkProductName(create.getTfproduct().getText())== true){
                JOptionPane.showMessageDialog(null, "This Product Name is already used.");
                create.getTfproduct().setText("");
            }
        }
        else if(e.getSource().equals(create.getTfprice())){
            if(create.getTfprice().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Plese Input Price.");
            }
            else if(this.isDouble(create.getTfprice().getText()) == false){
                JOptionPane.showMessageDialog(null, "Price must be Double");
                create.getTfprice().setText("");
            }
        }
        else if(e.getSource().equals(create.getTfweight())){
            if(create.getTfweight().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Plese Input Weight.");
            }
            else if(this.isDouble(create.getTfweight().getText()) == false){
                JOptionPane.showMessageDialog(null, "Weight must be Double");
                create.getTfweight().setText("");
            }
        }
        else if(e.getSource().equals(create.getTfamount())){
            if(create.getTfamount().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Plese Input Amount.");
            }
            else if(this.isInt(create.getTfamount().getText()) == false){
                JOptionPane.showMessageDialog(null, "Weight must be Integer");
                create.getTfamount().setText("");
            }
        }
    }

    
}
