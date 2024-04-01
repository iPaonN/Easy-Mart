package My_sql.ProjectData;

import My_sql.My_sql;
import java.io.*;
import java.sql.*;
import java.util.*;
import My_sql.UserData.User;
import My_sql.UserData.DoUserData;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import java.awt.Image;

public final class DoProjectData extends ProjectData{
    private My_sql data = new My_sql();
    
    public DoProjectData(){}
    
    public DoProjectData(String username, String projectname){
        Createtemplate(username, projectname);
    }
    
    @Override
    public void Createtemplate(String username, String projectname){
        
        String schema = username+"_"+projectname;
        
        try{
            data.connect();
            Connection conn = data.get_Connection();
            
            conn.createStatement().executeUpdate("CREATE SCHEMA " + schema);
            System.out.println("Create schema complete!");
            
            conn.createStatement().executeUpdate("USE " + schema);
            System.out.println("Connect to schema...");
            
            conn.createStatement().executeUpdate("""
                                                 CREATE TABLE `project_icon` (
                                                   `Icon` blob DEFAULT NULL
                                                 )""");
            System.out.println("Create history table complete!");
            
            this.INSERT_PROFILE(schema);
            
            conn.createStatement().executeUpdate("""
                                                 CREATE TABLE `memberteam` (
                                                   `staff_id` int NOT NULL AUTO_INCREMENT,
                                                   `staff_user` varchar(255) DEFAULT NULL,
                                                   `first_name` varchar(50) DEFAULT NULL,
                                                   `last_name` varchar(50) DEFAULT NULL,
                                                   `email` varchar(50) DEFAULT NULL,
                                                   `image` blob,
                                                   `staff_access` varchar(50) DEFAULT NULL,
                                                   PRIMARY KEY (`staff_id`)
                                                 )""");
            System.out.println("Create memberteam table complete!");
            
            //this.insert_member(schema, username, "Owner");
            
            conn.createStatement().executeUpdate("""
                                                 CREATE TABLE `product` (
                                                   `product_id` int NOT NULL ,
                                                   `product_name` varchar(50) DEFAULT NULL,
                                                   `type` varchar(50) NOT NULL,
                                                   `price` double DEFAULT NULL,
                                                   `weight` double DEFAULT NULL,
                                                   `quantity` int DEFAULT NULL,
                                                   `product_image` blob DEFAULT NULL,
                                                   PRIMARY KEY (`product_id`)
                                                 )""");
            System.out.println("Create product table complete!");
            
            conn.createStatement().executeUpdate("""
                                                 CREATE TABLE `history` (
                                                   `history_id` int NOT NULL AUTO_INCREMENT,
                                                   `product_id` int DEFAULT NULL,
                                                   `product_name` varchar(50) DEFAULT NULL,
                                                   `quantity` int DEFAULT NULL,
                                                   `type` varchar(50) DEFAULT NULL,
                                                   `action` varchar(50) DEFAULT NULL,
                                                   `action_time` datetime DEFAULT NULL,
                                                   `staff_user` varchar(255) DEFAULT NULL,
                                                   PRIMARY KEY (`history_id`)
                                                 ) """);
            System.out.println("Create history table complete!");
        
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void rename_schema(String user, String oldSchema, String newSchema){
          
        String oldname = user+"_"+oldSchema;
        String newname = user+"_"+newSchema;
        
        DoUserData DUD = new DoUserData();
        
        this.Createtemplate(user, newSchema);
        
        try{
            data.set_Schema(oldname);
            data.connect();
            
            Connection conn = data.get_Connection();

            try(PreparedStatement product_pstmt = conn.prepareStatement("SELECT * FROM product")){
            
                ResultSet product_rs = product_pstmt.executeQuery();
                
                while (product_rs.next()) {
                    this.copy_product(newname, product_rs.getInt("product_id"), product_rs.getString("product_name"),
                            product_rs.getString("type"), product_rs.getDouble("price"), product_rs.getDouble("weight"),
                            product_rs.getInt("quantity"), product_rs.getBlob("product_image"));
                }
            }
            try(PreparedStatement icon_pstmt = conn.prepareStatement("SELECT Icon FROM project_icon")){
            
                ResultSet icon_rs = icon_pstmt.executeQuery();
                
                while (icon_rs.next()) {
                    this.update_profile(newname, icon_rs.getBlob("Icon"));
                }
            }
            try(PreparedStatement member_pstmt = conn.prepareStatement("SELECT * FROM memberteam")){
            
                ResultSet member_rs = member_pstmt.executeQuery();
                
                
                while (member_rs.next()) {
                    
                    this.insert_member(newname, member_rs.getString("staff_user"), member_rs.getString("staff_access"));
                    DUD.RenameProject(member_rs.getString("staff_user"), oldname, newname);
                                  
                }
            }
            try(PreparedStatement history_pstmt = conn.prepareStatement("SELECT * FROM history")){
            
                ResultSet history_rs = history_pstmt.executeQuery();
                
                while (history_rs.next()) {
                    
                    this.copy_history(newname, history_rs.getInt("product_id"), 
                            history_rs.getString("product_name"), history_rs.getInt("quantity"), 
                            history_rs.getString("type"), history_rs.getString("action"), 
                            history_rs.getTimestamp("action_time"),history_rs.getString("staff_user"));
                    
                }
            }
            this.delete_project(oldname);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void rename_schema_for_editprofile(String user, String oldSchema, String newSchema, String project){
        
        String oldname = oldSchema;
        String newname = newSchema;
        
        this.Createtemplate(user, project);
        
        try{
            data.set_Schema(oldname);
            data.connect();
            
            Connection conn = data.get_Connection();

            try(PreparedStatement product_pstmt = conn.prepareStatement("SELECT * FROM product")){
            
                ResultSet product_rs = product_pstmt.executeQuery();
                
                while (product_rs.next()) {
                    this.copy_product(newname, product_rs.getInt("product_id"), product_rs.getString("product_name"),
                            product_rs.getString("type"), product_rs.getDouble("price"), product_rs.getDouble("weight"),
                            product_rs.getInt("quantity"), product_rs.getBlob("product_image"));
                }
            }
            try(PreparedStatement icon_pstmt = conn.prepareStatement("SELECT Icon FROM project_icon")){
            
                ResultSet icon_rs = icon_pstmt.executeQuery();
                
                while (icon_rs.next()) {
                    this.update_profile(newname, icon_rs.getBlob("Icon"));
                }
            }
            try(PreparedStatement member_pstmt = conn.prepareStatement("SELECT * FROM memberteam")){
            
                ResultSet member_rs = member_pstmt.executeQuery();
                
                while (member_rs.next()) {
                    
                    if(!(member_rs.getString("staff_user").equals(user))){
                        this.insert_member(newname, member_rs.getString("staff_user"), member_rs.getString("staff_access"));
                    }
                    
                }
            }
            try(PreparedStatement history_pstmt = conn.prepareStatement("SELECT * FROM history")){
            
                ResultSet history_rs = history_pstmt.executeQuery();
                
                while (history_rs.next()) {
                    
                    this.copy_history(newname, history_rs.getInt("product_id"), 
                            history_rs.getString("product_name"), history_rs.getInt("quantity"), 
                            history_rs.getString("type"), history_rs.getString("action"), 
                            history_rs.getTimestamp("action_time"),history_rs.getString("staff_user"));
                    
                }
            }
            this.delete_project(oldname);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void delete_project(String username, String projectname){
        String schema = username + "_" + projectname;
        
        try{
            data.connect();
            Connection conn = data.get_Connection();
            
            String sql = "DROP DATABASE " + schema;
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate(sql);
            System.out.println("Schema is deleted!");
            
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            data.disconnect();
        }
    }

    public ResultSet getRS(String schema, String table) throws SQLException{
        data.set_Schema(schema);
        data.connect();
        Connection conn = data.get_Connection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);

        return rs;
        
    }
    public int getIntdata(ResultSet rs, String pointer_column, String  pointer_data, String want_column) throws SQLException{
        while(rs.next()) {
            String column = rs.getString(pointer_column);
            if (column.equals(pointer_data)) {
                int want = rs.getInt(want_column);
                return want;
            }
        }
        return -1;
    }
    
    public double getdoubledata(ResultSet rs, String pointer_column, String  pointer_data, String want_column) throws SQLException{
        while(rs.next()) {
            String column = rs.getString(pointer_column);
            if (column.equals(pointer_data)) {
                double want = rs.getDouble(want_column);
                return want;
            }
        }
        return -1;
    }
    
    public String getStringdata(ResultSet rs, String pointer_column, String  pointer_data, String want_data) throws SQLException{
        while(rs.next()) {
            String column = rs.getString(pointer_column);
            if (column.equals(pointer_data)) {
                String want = rs.getString(want_data);
                return want;
            }
        }
        return null;
    }
    
    public void set_product(String schema, int product_id, String product_name, String type, double price, double weight, int quantity, File product_image, String user){
        try{
            FileInputStream inputStream = new FileInputStream(product_image);
            
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO product (product_id, product_name, type, price, weight, quantity, product_image) VALUES (?, ?, ?, ?, ?, ?, ?)")){

                pstmt.setInt(1, product_id);
                pstmt.setString(2, product_name);
                pstmt.setString(3, type);
                pstmt.setDouble(4, price);
                pstmt.setDouble(5, weight);
                pstmt.setInt(6, quantity);
                pstmt.setBinaryStream(7, inputStream);
                
                pstmt.executeUpdate();
                    
                System.out.println("Add product data completed.");
                
                this.set_history(schema, product_id, product_name, quantity, type, "add", user);
                
            }
        }catch (IOException | SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void copy_product(String schema, int product_id, String product_name, String type, double price, double weight, int quantity, Blob product_image){
        try{
            
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO product (product_id, product_name, type, price, weight, quantity, product_image) VALUES (?, ?, ?, ?, ?, ?, ?)")){

                pstmt.setInt(1, product_id);
                pstmt.setString(2, product_name);
                pstmt.setString(3, type);
                pstmt.setDouble(4, price);
                pstmt.setDouble(5, weight);
                pstmt.setInt(6, quantity);
                pstmt.setBlob(7, product_image);
                
                pstmt.executeUpdate();
                    
                System.out.println("Add product data completed.");
                
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public Product get_product(String schema, String product_name){
        Product p1 = null;
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product WHERE product_name = ?")){

                pstmt.setString(1, product_name);
                
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    p1 = new Product();
                    p1.setId(rs.getInt("product_id"));
                    p1.setName(rs.getString("product_name"));
                    p1.setType(rs.getString("type"));
                    p1.setPrice(rs.getDouble("price"));
                    p1.setWeight(rs.getDouble("weight"));
                    p1.setQuantity(rs.getInt("quantity"));
                    p1.setImage(rs.getBlob("product_image"));
                }
                    
                System.out.println("get product data completed.");
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
            return p1;
        }
    
    }
    
    public Product get_product(String schema, int product_id){
        Product p1 = null;
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product WHERE product_id = ?")){

                pstmt.setInt(1, product_id);
                
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    p1 = new Product();
                    p1.setId(rs.getInt("product_id"));
                    p1.setName(rs.getString("product_name"));
                    p1.setType(rs.getString("type"));
                    p1.setPrice(rs.getDouble("price"));
                    p1.setWeight(rs.getDouble("weight"));
                    p1.setQuantity(rs.getInt("quantity"));
                    p1.setImage(rs.getBlob("product_image"));
                }
                    
                System.out.println("get product data completed.");
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
            return p1;
        }
    
    }
    
    public ArrayList<Product> getAll_product(String schema){
        ArrayList<Product> allproduct = new ArrayList<>();
        Product p1 = null;
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product")){
                
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    p1 = new Product();
                    p1.setId(rs.getInt("product_id"));
                    p1.setName(rs.getString("product_name"));
                    p1.setType(rs.getString("type"));
                    p1.setPrice(rs.getDouble("price"));
                    p1.setWeight(rs.getDouble("weight"));
                    p1.setQuantity(rs.getInt("quantity"));
                    p1.setImage(rs.getBlob("product_image"));
                    allproduct.add(p1);
                }
                    
                System.out.println("get All product data completed.");
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
            return allproduct;
        }
        
    }
    
    public HashSet<String> getAll_Type(String schema){
        HashSet<String> type = new HashSet<>();
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT type FROM product")){
                
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    type.add(rs.getString("type"));
                }
                    
                System.out.println("get All type data completed.");
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
            return type;
        }
    }
    
    public void remove_product(String schema, String user, String product_name){
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement his_pstmt = conn.prepareStatement("SELECT * FROM product WHERE product_name = ?")){
            
                his_pstmt.setString(1, product_name);
                
                ResultSet rs = his_pstmt.executeQuery();
                
                while(rs.next()){
                    this.set_history(schema, rs.getInt("product_id"), product_name, -1, rs.getString("type"), "remove", user);
                }
                
            }
            
            try(PreparedStatement del_pstmt = conn.prepareStatement("DELETE FROM product WHERE product_name = ?")){
                
                del_pstmt.setString(1, product_name);
                
                del_pstmt.executeUpdate();
                
                System.out.println("remove product completed.");
                
            }
        
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void remove_product(String schema, String user, int product_id){
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement his_pstmt = conn.prepareStatement("SELECT * FROM product WHERE product_id = ?")){
            
                his_pstmt.setInt(1, product_id);
                
                ResultSet rs = his_pstmt.executeQuery();
                
                while(rs.next()){
                    this.set_history(schema, product_id, rs.getString("product_name"), -1, rs.getString("type"), "remove", user);
                }
                
            }
            
            try(PreparedStatement del_pstmt = conn.prepareStatement("DELETE FROM product WHERE product_id = ?")){
                
                del_pstmt.setInt(1, product_id);
                
                del_pstmt.executeUpdate();
                
                System.out.println("remove product completed.");
                
            }
        
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void decrease_product(String schema, String user, String product_name, int amount){
        
        int quantity = 0;
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement get_pstmt = conn.prepareStatement("SELECT * FROM product WHERE product_name = ?")){
            
                get_pstmt.setString(1, product_name);
                
                ResultSet rs = get_pstmt.executeQuery();
                
                while(rs.next()){
                    quantity = rs.getInt("quantity");
                    if(quantity-amount >= 0){
                        this.set_history(schema, rs.getInt("product_id"), product_name, amount, rs.getString("type"), "decrease", user);
                    }
                }
                
            }
            
            try(PreparedStatement update_pstmt = conn.prepareStatement("UPDATE product SET quantity = ? WHERE product_name = ?")){
                
                if(quantity-amount < 0){
                    System.out.println("can't decrease.");
                }else{
                    update_pstmt.setInt(1, (quantity-amount));
                    update_pstmt.setString(2, product_name);
                
                    update_pstmt.executeUpdate();
                
                    System.out.println("decrease product completed.");
                }
                
            }
        
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void decrease_product(String schema, String user, int product_id, int amount){
        
        int quantity = 0;
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement get_pstmt = conn.prepareStatement("SELECT * FROM product WHERE product_id = ?")){
            
                get_pstmt.setInt(1, product_id);
                
                ResultSet rs = get_pstmt.executeQuery();
                
                while(rs.next()){
                    quantity = rs.getInt("quantity");
                    if(quantity-amount >= 0){
                        this.set_history(schema, product_id, rs.getString("product_name"), amount, rs.getString("type"), "decrease", user);
                    }
                }
                
            }
            
            try(PreparedStatement update_pstmt = conn.prepareStatement("UPDATE product SET quantity = ? WHERE product_id = ?")){
                
                if(quantity-amount < 0){
                    System.out.println("can't decrease.");
                }else{
                    update_pstmt.setInt(1, (quantity-amount));
                    update_pstmt.setInt(2, product_id);
                
                    update_pstmt.executeUpdate();
                
                    System.out.println("decrease product completed.");
                }
                
            }
        
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void Increase_product(String schema, String user, String product_name, int amount){
                int quantity = 0;
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement get_pstmt = conn.prepareStatement("SELECT * FROM product WHERE product_name = ?")){
            
                get_pstmt.setString(1, product_name);
                
                ResultSet rs = get_pstmt.executeQuery();
                
                while(rs.next()){
                    quantity = rs.getInt("quantity");
                    
                    this.set_history(schema, rs.getInt("product_id"), product_name, amount, rs.getString("type"), "increase", user);
                    
                }
                
            }
            
            try(PreparedStatement update_pstmt = conn.prepareStatement("UPDATE product SET quantity = ? WHERE product_name = ?")){
                
                update_pstmt.setInt(1, (quantity+amount));
                update_pstmt.setString(2, product_name);
                
                update_pstmt.executeUpdate();
                
                System.out.println("increase product completed.");
                
            }
        
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void Increase_product(String schema, String user, int product_id, int amount){
        int quantity = 0;
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement get_pstmt = conn.prepareStatement("SELECT * FROM product WHERE product_id = ?")){
            
                get_pstmt.setInt(1, product_id);
                
                ResultSet rs = get_pstmt.executeQuery();
                
                while(rs.next()){
                    quantity = rs.getInt("quantity");

                    this.set_history(schema, product_id, rs.getString("product_name"), amount, rs.getString("type"), "increase", user);
                    
                }
                
            }
            
            try(PreparedStatement update_pstmt = conn.prepareStatement("UPDATE product SET quantity = ? WHERE product_id = ?")){
                

                update_pstmt.setInt(1, (quantity+amount));
                update_pstmt.setInt(2, product_id);
                
                update_pstmt.executeUpdate();
                
                System.out.println("decrease product completed.");
                
                
            }
        
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void set_history(String schema, int product_id, String product_name, int quantity, String type, String action, String user){
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO history (product_id, product_name, quantity, type, action, action_time, staff_user) VALUES (?, ?, ?, ?, ?, ?, ?)")){

                pstmt.setInt(1, product_id);
                pstmt.setString(2, product_name); 
                pstmt.setInt(3, quantity); 
                pstmt.setString(4, type); 
                pstmt.setString(5, action); 
                pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis())); 
                pstmt.setString(7, user); 
                
                pstmt.executeUpdate();
                    
                System.out.println("Add history data completed.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void copy_history(String schema, int product_id, String product_name, int quantity, String type, String action, Timestamp action_time, String user){
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO history (product_id, product_name, quantity, type, action, action_time, staff_user) VALUES (?, ?, ?, ?, ?, ?, ?)")){

                pstmt.setInt(1, product_id);
                pstmt.setString(2, product_name); 
                pstmt.setInt(3, quantity); 
                pstmt.setString(4, type); 
                pstmt.setString(5, action); 
                pstmt.setTimestamp(6, action_time); 
                pstmt.setString(7, user); 
                
                pstmt.executeUpdate();
                    
                System.out.println("Add history data completed.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public ArrayList<History> get_Historys_date(String schema, String date){
        ///dd-MM-YYYY///
        ArrayList<History> allhisdata = new ArrayList<>();
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date utilDate = sdf.parse(date);
            
            String formattedDate = sdf.format(utilDate);
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM history WHERE DATE_FORMAT(action_time, '%d-%m-%Y') = ?")){
            
                pstmt.setString(1, formattedDate);
                
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    Timestamp actionTime = rs.getTimestamp("action_time");
                    LocalDateTime localDateTime = actionTime.toLocalDateTime();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String time = localDateTime.format(formatter);
                    allhisdata.add(new History(rs.getInt("history_id"), 
                            rs.getInt("product_id"), rs.getString("product_name"), 
                            rs.getInt("quantity"), rs.getString("type"), 
                            rs.getString("action"), localDateTime , rs.getString("staff_user"), time));
                    
                    System.out.println("Get History completed.");
                }
                
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
            return allhisdata;
        }
        
    }
    
    public ArrayList<History> get_Historys_month(String schema, String month){
        //MM//
        ArrayList<History> allhisdata = new ArrayList<>();
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            SimpleDateFormat sdf = new SimpleDateFormat("MM");
            java.util.Date utilDate = sdf.parse(month);
            
            String formattedDate = sdf.format(utilDate);
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM history WHERE DATE_FORMAT(action_time, '%m') = ?")){
            
                pstmt.setString(1, formattedDate);
                
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    Timestamp actionTime = rs.getTimestamp("action_time");
                    LocalDateTime localDateTime = actionTime.toLocalDateTime();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String time = localDateTime.format(formatter);
                    allhisdata.add(new History(rs.getInt("history_id"), 
                            rs.getInt("product_id"), rs.getString("product_name"), 
                            rs.getInt("quantity"), rs.getString("type"), 
                            rs.getString("action"), localDateTime , rs.getString("staff_user"), time));
                    
                    System.out.println("Get History completed.");
                }
                
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
            return allhisdata;
        }
        
    }
    public ArrayList<History> get_Historys_year(String schema, String year){
        ///YYYY///
        ArrayList<History> allhisdata = new ArrayList<>();
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            java.util.Date utilDate = sdf.parse(year);
            
            String formattedDate = sdf.format(utilDate);
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM history WHERE DATE_FORMAT(action_time, '%Y') = ?")){
            
                pstmt.setString(1, formattedDate);
                
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    Timestamp actionTime = rs.getTimestamp("action_time");
                    LocalDateTime localDateTime = actionTime.toLocalDateTime();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String time = localDateTime.format(formatter);
                    allhisdata.add(new History(rs.getInt("history_id"), 
                            rs.getInt("product_id"), rs.getString("product_name"), 
                            rs.getInt("quantity"), rs.getString("type"), 
                            rs.getString("action"), localDateTime , rs.getString("staff_user"), time));
                    
                    System.out.println("Get History completed.");
                }
                
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
            return allhisdata;
        }
        
    }
    public ArrayList<History> getAll_Historys(String schema){
        ArrayList<History> allhisdata = new ArrayList<>();
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
                
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM history")){
            
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    Timestamp actionTime = rs.getTimestamp("action_time");
                    LocalDateTime localDateTime = actionTime.toLocalDateTime();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String time = localDateTime.format(formatter);
                    allhisdata.add(new History(rs.getInt("history_id"), 
                            rs.getInt("product_id"), rs.getString("product_name"), 
                            rs.getInt("quantity"), rs.getString("type"), 
                            rs.getString("action"), localDateTime , rs.getString("staff_user"), time));
                    
                    System.out.println("Get History completed.");
                }
                
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
            return allhisdata;
        }
        
    }
    
    private final void INSERT_PROFILE(String schema){
        try{
            
            Random random = new Random();
            int random_number = random.nextInt(4)+1;
                
            File imageFile = new File("src/My_sql/UserData/Image/image"+random_number+".png");
            FileInputStream inputStream = new FileInputStream(imageFile);
            
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO project_icon (Icon) VALUES (?)")){

                pstmt.setBinaryStream(1, inputStream);
                
                pstmt.executeUpdate();
                    
                System.out.println("Add history project_icon completed.");
            }
        }catch (IOException | SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void update_profile(String schema, File pathFile){
        try{
            FileInputStream inputStream = new FileInputStream(pathFile);
            
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE project_icon SET ICON = ?")){
                
                pstmt.setBinaryStream(1, inputStream);
                
                pstmt.executeUpdate();
                
                System.out.println("Change Image completed.");
                
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void update_profile(String schema, Blob blob){
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE project_icon SET ICON = ?")){
                
                pstmt.setBlob(1, blob);
                
                pstmt.executeUpdate();
                
                System.out.println("Change Image completed.");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public Image Get_Profile(String schema){
        Image image = null;
        try{
            
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT Icon FROM project_icon")){
                
                ResultSet rs = pstmt.executeQuery();
                
                if(rs.next()){
                    Blob blob = rs.getBlob("Icon");
                    byte[] imageData = blob.getBytes(1, (int) blob.length());

                    image = ImageIO.read(new ByteArrayInputStream(imageData));
                    
                }
                
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }finally{
            data.disconnect();
            return image;
        }
    }
    
    public ArrayList<Member> Get_Members(String schema){
        
        ArrayList<Member> allmember = new ArrayList<>();
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM memberteam")){
            
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    allmember.add(new Member(rs.getInt("staff_id"), rs.getString("staff_user"), 
                            rs.getString("first_name"), rs.getString("last_name"), 
                            rs.getString("email"), rs.getBlob("image"), rs.getString("staff_access")));
                }
                
            }
           
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
            return allmember;
        }
    }
    
    public void insert_member(String schema, String username, String access){
        
        DoUserData user = new DoUserData();
        User p1 = user.Get_User(username);
        
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO memberteam (staff_user, first_name, last_name, email, image, staff_access) VALUES (?, ?, ?, ?, ?, ?)")){

                pstmt.setString(1, p1.getUser_name());
                pstmt.setString(2, p1.getFirst_name());
                pstmt.setString(3, p1.getLast_name());
                pstmt.setString(4, p1.getEmail());
                pstmt.setBlob(5, p1.getImage());
                pstmt.setString(6, access);
                
                pstmt.executeUpdate();
                    
                System.out.println("Insert member completed.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void remove_member(String schema, String username){
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("DELETE FROM memberteam WHERE staff_user = ?")){

                pstmt.setString(1, username);

                pstmt.executeUpdate();
                    
                System.out.println("Remove member completed.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void delete_project(String schema){
        try{
            data.set_Schema("");
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("DROP SCHEMA " + schema)){

                pstmt.executeUpdate();
                    
                System.out.println("Remove project completed.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public void update_product_quantity(String schema,String product_name, int quantity){
        try{
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE product SET quantity = ? WHERE product_name = ?")){
                
                pstmt.setInt(1, quantity);
                pstmt.setString(2, product_name);
                
                pstmt.executeUpdate();
                
                System.out.println("Change update_product_quantity completed.");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    
//    public static void main(String[] args) {
//        DoProjectData p1 = new DoProjectData();
//        String schema = "zedl3all_pj2";
//        p1.update_product_quantity(schema, "A1", 200);
        //System.out.println(p1.get_Historys_year(schema,"2024"));
        //p1.insert_member(schema, "zedl3all", "Owner");
        //p1.rename_schema("zedl3all", "pj1", "pj2");
        //System.out.println(p1.get_Historys("p_pj1", "28-03-2024").get(0).getTime());
        
//        try {
//        ResultSet rs = p1.getRS("zedl3all_Project1", "history");
//        System.out.println(p1.getIntdata(rs, "product_name", "", ""));
//        rs.getStatement().getConnection().close();
//    } catch (Exception e){
//        e.printStackTrace();
//    }
//  }
}
