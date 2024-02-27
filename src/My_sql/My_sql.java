package My_sql;

import java.sql.*;

public class My_sql implements Connectable {
    public static final String URL = "jdbc:mysql://localhost:3306/";
    private String schema;
    private String table;
    public static final String USER = "root";
    public static final String PASS = "1234";
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    
    public My_sql(){
        this("", "");
    }
    
    public My_sql(String schema, String table){
        this.schema = schema;
        this.table = table;
    }
    
    public void set_Schema(String schema){
        this.schema = schema;
    }
    public String get_Schema(){
        return schema;
    }
    public void set_Table(String table){
        this.schema = table;
    }
    public String get_Table(){
        return table;
    }
    
    public ResultSet get_ResultSet(){
        return rs;
    }
    
    public Connection get_Connection(){
        return conn;
    }
    
    @Override
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(URL + schema, USER, PASS);
            
            if (conn != null) {
                System.out.println("Connected successfully.");
            } else {
                System.out.println("Failed to connect.");
            }
            
            stmt = conn.createStatement();
            String sql = "SELECT * FROM " + table;
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void disconnect(){
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Disconnect Connection.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
                System.out.println("Disconnect ResultSet.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
                System.out.println("Disconnect Statement.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }  
}
