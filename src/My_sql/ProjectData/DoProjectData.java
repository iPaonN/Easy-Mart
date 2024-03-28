package My_sql.ProjectData;

import My_sql.My_sql;
import java.sql.*;

public final class DoProjectData extends ProjectData{
    private My_sql data = new My_sql();
    
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
                                                   `Icon` blob
                                                 )""");
            System.out.println("Create history table complete!");
            
            conn.createStatement().executeUpdate("""
                                                 CREATE TABLE `memberteam` (
                                                   `staff_id` int NOT NULL,
                                                   `staff_user` varchar(255) DEFAULT NULL,
                                                   `first_name` varchar(50) DEFAULT NULL,
                                                   `last_name` varchar(50) DEFAULT NULL,
                                                   `email` varchar(50) DEFAULT NULL,
                                                   `image` blob,
                                                   `staff_access` tinyint DEFAULT NULL,
                                                   PRIMARY KEY (`staff_id`)
                                                 )""");
            System.out.println("Create memberteam table complete!");
            
            conn.createStatement().executeUpdate("""
                                                 CREATE TABLE `producttype` (
                                                   `type_id` int NOT NULL AUTO_INCREMENT,
                                                   `type_name` varchar(50) NOT NULL,
                                                   PRIMARY KEY (`type_id`)
                                                 ) """);
            System.out.println("Create producttype table complete!");
            
            conn.createStatement().executeUpdate("""
                                                 CREATE TABLE `product` (
                                                   `product_id` int NOT NULL,
                                                   `product_name` varchar(50) DEFAULT NULL,
                                                   `type_id` int DEFAULT NULL,
                                                   `price` int DEFAULT NULL,
                                                   `weight` int DEFAULT NULL,
                                                   `quantity` int DEFAULT NULL,
                                                   `added_time` datetime DEFAULT NULL,
                                                   PRIMARY KEY (`product_id`),
                                                   KEY `type_id` (`type_id`),
                                                   CONSTRAINT `product_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `producttype` (`type_id`)
                                                 )""");
            System.out.println("Create product table complete!");
            
            conn.createStatement().executeUpdate("""
                                                 CREATE TABLE `typeaction` (
                                                   `type_id` int NOT NULL AUTO_INCREMENT,
                                                   `type_name` varchar(50) NOT NULL,
                                                   PRIMARY KEY (`type_id`)
                                                 )""");
            System.out.println("Create typeaction table complete!");
            
            conn.createStatement().executeUpdate("""
                                                 CREATE TABLE `history` (
                                                   `history_id` int NOT NULL,
                                                   `product_id` int DEFAULT NULL,
                                                   `product_name` varchar(50) DEFAULT NULL,
                                                   `quantity` int DEFAULT NULL,
                                                   `type_id` int DEFAULT NULL,
                                                   `action_time` datetime DEFAULT NULL,
                                                   `staff_user` varchar(255) DEFAULT NULL,
                                                   PRIMARY KEY (`history_id`),
                                                   KEY `type_id` (`type_id`),
                                                   KEY `product_id` (`product_id`),
                                                   KEY `staff_id` (`staff_user`),
                                                   CONSTRAINT `history_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `typeaction` (`type_id`),
                                                   CONSTRAINT `history_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
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
    
//    public static void main(String[] args) {
//        DoProjectData p1 = new DoProjectData("zedl3all", "Project1");
//        try {
//        ResultSet rs = p1.getRS("zedl3all_Project1", "history");
//        System.out.println(p1.getIntdata(rs, "product_name", "", ""));
//        rs.getStatement().getConnection().close();
//    } catch (Exception e){
//        e.printStackTrace();
//    }
//    }
}
