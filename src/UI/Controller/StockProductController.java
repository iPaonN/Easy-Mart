package UI.Controller;

import My_sql.My_sql;
import UI.Model.StockProductModel;
import UI.View.StockProduct;
import UI.View.SubProduct;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StockProductController {
    private String username, projectname, schema;
    private StockProduct view;
    private StockProductModel model;
    private SubProduct subproduct;
    
    public StockProductController(String username, String projectname){
        this.username = username;
        this.projectname = projectname;
        this.schema = this.username+"_"+this.projectname;
        view = new StockProduct();
        model = new StockProductModel(this.username, this.projectname);
        model.SetProductdata(1, "productname", 1, 15, 1, 3);
        model.SetProductdata(2, "ABC", 1, 300, 1, 5);
        model.SetProductdata(3, "Third", 1, 499, 1, 8);
        displaydata();
        
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
                view.getsubpanel().add(subproduct);
                view.getsubpanel().revalidate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
//    public static void main(String[] args) {
//        new StockProductController(name, projectname);
//    }
//    
}
