package My_sql;

import java.sql.*;

public class CheckRegis_Data extends My_sql{
    
    public boolean CheckUsername(String username){
        try {
            super.set_Schema("staff"); //Use in staff schema only
            
            super.connect();
            Connection conn = super.get_Connection();
            
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM staff_login WHERE staff_user = ?")){
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
            super.set_Schema("staff"); //Use in staff schema only
            
            super.connect();
            Connection conn = super.get_Connection();
            
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM staff_info WHERE email = ?")){
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
    
    public static void main(String[] args) {
        CheckRegis_Data t1 = new CheckRegis_Data();
        t1.CheckUsername("zedl3all");
        t1.CheckEmail("66070082@kmitl.ac.th");
    }
}
