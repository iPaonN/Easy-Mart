package My_sql;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class CheckLogin_Data extends My_sql{
    
    public CheckLogin_Data(){
        super();
    }
    public CheckLogin_Data(String schema, String table){
        super(schema, table);
    }
    
    public boolean CheckData(String username, String password){

        try {
            super.connect();
            Connection conn = super.get_Connection();
            
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?")){
                pstmt.setString(1, username);
                
                try(ResultSet rs = pstmt.executeQuery()){
                    
                    if (rs.next()){
                        
                        String gethashingpassword = rs.getString("password");
                        
                        if(BCrypt.checkpw(password, gethashingpassword)){
                            System.out.println("Login successful!");
                            return true;
                        }else{
                            System.out.println("Incorrect username or password.");
                            return false;
                        }
                        
                        
                    }else{
                        System.out.println("You don't have Account.");
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
}
