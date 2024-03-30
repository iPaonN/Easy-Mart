package UI.Model;

import My_sql.My_sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class StockProductModel {
    private My_sql sql;
    Statement stmt = null;
    Connection conn = null;
    private String username;
    private String projectname;
    private String schema;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public StockProductModel(String name, String projectname) {
        this.username = name;
        this.projectname = projectname;
        schema = this.username+"_"+this.projectname;
    }
    


    public void SetProductdata(int id,String productname,int type,double price,double weight,int amount){
      My_sql sql = new My_sql();
      try{
        sql.set_Schema(this.schema);
        sql.connect();
        conn = sql.get_Connection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO product (product_id, product_name, type_id, price, weight, quantity) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, id);
        stmt.setString(2, productname);
        stmt.setInt(3, type);
        stmt.setDouble(4, price);
        stmt.setDouble(5, weight);
        stmt.setInt(6, amount);
        int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
            System.out.println("A new row was inserted successfully!");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
            sql.disconnect();
        }
    }
}

