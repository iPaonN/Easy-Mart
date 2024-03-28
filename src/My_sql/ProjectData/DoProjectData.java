package My_sql.ProjectData;

import My_sql.My_sql;
import java.io.*;
import java.sql.*;
import java.util.*;

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

    public ResultSet getRS(String schema, String table) throws SQLException{
        data.set_Schema(schema);
        data.connect();
        Connection conn = data.get_Connection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);

        return rs;
        
    }
    public int getIntdata(ResultSet rs, String pointer_column, String  pointer_data, String want_data) throws SQLException{
        while(rs.next()) {
            String column = rs.getString(pointer_column);
            if (column.equals(pointer_data)) {
                int want = rs.getInt(want_data);
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
    
    public File Get_Profile(String schema){
        File imgFile = null;
        try{
            
            data.set_Schema(schema);
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT Icon FROM project_icon")){
                
                ResultSet rs = pstmt.executeQuery();
                
                if(rs.next()){
                    InputStream is = rs.getBinaryStream("image");
                    
                    imgFile = new File(schema+".png");
                    
                    try(OutputStream os = new FileOutputStream(imgFile)){
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        
                        while((bytesRead = is.read(buffer)) != -1){
                            os.write(buffer, 0, bytesRead);
                        }
                    }
                    
                }
                
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }finally{
            data.disconnect();
            return imgFile;
        }
    }
    
//    public static void main(String[] args) {
//        DoProjectData p1 = new DoProjectData("p","pj1");
//        p1.set_product("p_pj1", 101, "Coke", "Drink", 12.5, 15.5, 100, new File("src/My_sql/UserData/Image/image1.png"), "zedl3all");
    
//        try {
//        ResultSet rs = p1.getRS("zedl3all_Project1", "history");
//        System.out.println(p1.getIntdata(rs, "product_name", "", ""));
//        rs.getStatement().getConnection().close();
//    } catch (Exception e){
//        e.printStackTrace();
//    }
//  }
}
