package UI.Model;

import My_sql.My_sql;
import My_sql.ProjectData.DoProjectData;
import My_sql.ProjectData.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StockProductModel {
    private My_sql sql;
    Statement stmt = null;
    Connection conn = null;
    private String username;
    private String projectname;
    private String schema;
    private DoProjectData promanager;
    
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
        promanager = new DoProjectData();
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
    public ArrayList<String> filterType(String type){
        ArrayList<Product> productlist = promanager.getAll_product(this.projectname);
        ArrayList<String> result = new ArrayList<String>();
        for (Product p: productlist){
            if (type.equals("All")){
                result.add(p.getName());
            }
            else if(p.getType().equals(type) == true){
                result.add(p.getName());
            }
        }
        return result;
    }
    public ArrayList<Product> filterName(String productname, String type){
        ArrayList<String> listtype = this.filterType(type);
        ArrayList<Product> result = new ArrayList<Product>();
        if(productname.equals("")){
            for (String lt: listtype){
                result.add(promanager.get_product(this.projectname, lt));
            }
        }
        else{
            for (String lt: listtype){
                if (lt.contains(productname) == true){
                   result.add(promanager.get_product(this.projectname, lt)); 
                }
            }
        }
        return result;
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


}

