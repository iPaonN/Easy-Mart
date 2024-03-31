package UI.Model;

import My_sql.My_sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        schema = this.projectname;
    }
    public boolean checkProductName(String productname) {
        try {
            My_sql base= new My_sql(this.schema, "product");
            base.connect();
            Connection conner = base.get_Connection();
            
            try (PreparedStatement pstmt = conner.prepareStatement("SELECT * FROM product WHERE product_name = ?")){
                pstmt.setString(1, productname);
                
                try(ResultSet rs = pstmt.executeQuery()){
                    
                    if (rs.next()){
                        
                        System.out.println("productname has already been used.");
                        System.out.println("Please change productname.");
                        base.disconnect();
                        return true;
                        
                    }else{
                        System.out.println("No one has already used.");
                        base.disconnect();
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean checkCanUse(String productname){
        for (char c : productname.toCharArray()){
            if (Character.isLetterOrDigit(c) == false){
                return false;
            } 
        }
        return true;
    }
    public boolean checkType(String type){
        for (char c : type.toCharArray()){
            if (Character.isLetter(c) == false){
                return false;
            } 
        }
        return true;
    }
    public boolean checkProductID(int id) {
        try {
            My_sql base= new My_sql(this.schema, "product");
            base.connect();
            Connection conner = base.get_Connection();
            
            try (PreparedStatement pstmt = conner.prepareStatement("SELECT * FROM product WHERE product_id = ?")){
                pstmt.setString(1, id+"");
                
                try(ResultSet rs = pstmt.executeQuery()){
                    
                    if (rs.next()){
                        
                        System.out.println("id has already been used.");
                        System.out.println("Please change id.");
                        base.disconnect();
                        return true;
                        
                    }else{
                        System.out.println("No one has already used.");
                        base.disconnect();
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public void SetProductdata(String productname, int type, double price, double weight, int amount) {
    My_sql sql = new My_sql();
    try {
        sql.set_Schema(this.schema);
        sql.connect();
        conn = sql.get_Connection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO product (product_name, type_id, price, weight, quantity) VALUES (?, ?, ?, ?, ?)");
        stmt.setString(1, productname);
        stmt.setInt(2, type);
        stmt.setDouble(3, price);
        stmt.setDouble(4, weight);
        stmt.setInt(5, amount);
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

