package My_sql;

import java.sql.*;

public class My_sql implements Connectable {
    public static final String URL = "jdbc:mysql://localhost:3306/";
    private String schema;
    private String table;
    public static final String USER = "root";
    public static final String PASS = "1234";
    public static final String SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection conn;

    
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
        this.table = table;
    }
    public String get_Table(){
        return table;
    }
    
    public Connection get_Connection(){
        return conn;
    }
    
    @Override
    public void connect(){
        try {
            Class.forName(SQL_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(URL + schema, USER, PASS);
            
            if (conn != null) {
                System.out.println("Connected successfully.");
            } else {
                System.out.println("Failed to connect.");
            }
            
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
    }
}
