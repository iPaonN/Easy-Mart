package My_sql;

import java.sql.*;

public class CheckRegis_Data extends My_sql{
    
    public CheckRegis_Data(){
        super();
    }
    public CheckRegis_Data(String schema, String table){
        super(schema, table);
    }
    
    public boolean CheckUsername(String username){
        try {
            super.connect();
            Connection conn = super.get_Connection();
            
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?")){
                pstmt.setString(1, username);
                
                try(ResultSet rs = pstmt.executeQuery()){
                    
                    if (rs.next()){
                        
                        System.out.println("username has already been used.");
                        System.out.println("Please change username.");
                        return true;
                        
                    }else{
                        System.out.println("No one has already used.");
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally{
            super.disconnect();
        }
    }
    
    public boolean CheckEmail(String email){
        try {
            super.connect();
            Connection conn = super.get_Connection();
            
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE email = ?")){
                pstmt.setString(1, email);
                
                try(ResultSet rs = pstmt.executeQuery()){
                    
                    if (rs.next()){
                        System.out.println("email has already been used.");
                        return true;
                    }else{
                        System.out.println("No one has already used.");
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally{
            super.disconnect();
        }
    }
    
//    public static void main(String[] args) {
//        CheckRegis_Data t1 = new CheckRegis_Data("sys", "users");
//        t1.CheckUsername("0");
//        t1.CheckEmail("55555@gmail.com");
//    }
}
