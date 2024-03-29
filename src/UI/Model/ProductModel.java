package UI.Model;

import My_sql.My_sql;
import java.sql.*;

public class ProductModel {
    private int id;
    private String productName;
    private String type;
    private double pricePerPiece;
    private double weight;
    private int amount;
    Statement stmt = null;
    Connection conn = null;
    
    public ProductModel(){
        
    }
    
    public ProductModel(int id, String productName, String type, double pricePerPiece, double weight, int amount) {
        this.id = id;
        this.productName = productName;
        this.type = type;
        this.pricePerPiece = pricePerPiece;
        this.weight = weight;
        this.amount = amount;
    }
    
    public int getID() {
        return id;
    }
    
    public String getProductName() {
        return productName;
    }

    public String getType() {
        return type;
    }

    public double getPricePerPiece() {
        return pricePerPiece;
    }

    public double getWeight() {
        return weight;
    }

    public int getAmount() {
        return amount;
    }
    
    public void SetProducttype(int type_id, String type_name) {
        My_sql sql = new My_sql();
      try{
        sql.set_Schema("zedl3all_Project1");
        sql.connect();
        conn = sql.get_Connection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO producttype (type_id, type_name) VALUES (?, ?)");
        stmt.setInt(1, type_id);
        stmt.setString(2, type_name);
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
        sql.set_Schema("zedl3all_Project1");
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
    
    public void DeleteProduct(int id) {
        My_sql sql = new My_sql();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            sql.set_Schema("zedl3all_Project1");
            sql.connect();
            conn = sql.get_Connection();

            String query = "DELETE FROM product WHERE product_id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Product with ID: " + id + " has been deleted successfully.");
            } else {
                System.out.println("Product with ID: " + id + " was not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sql.disconnect();
        }
    }

    public void UpdateProduct(int id, double newPrice, int newAmount) {
        My_sql sql = new My_sql();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            sql.set_Schema("zedl3all_Project1");
            sql.connect();
            conn = sql.get_Connection();

            String query = "UPDATE product SET price = ?, quantity = ? WHERE product_id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setDouble(1, newPrice);
            stmt.setInt(2, newAmount);
            stmt.setInt(3, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Product with ID: " + id + " has been updated successfully.");
            } else {
                System.out.println("Product with ID: " + id + " was not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sql.disconnect();
        }
    }


    
    public void fetchProductData() {
        My_sql sql = new My_sql();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            sql.set_Schema("zedl3all_Project1");
            sql.connect();
            conn = sql.get_Connection();

            String query = "SELECT * FROM product";
            stmt = conn.prepareStatement(query);

            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("product_name");
                int typeId = rs.getInt("type_id");
                double price = rs.getDouble("price");
                double weight = rs.getDouble("weight");
                int amount = rs.getInt("quantity");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sql.disconnect();
        }
    }
    
}

