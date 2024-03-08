package My_sql;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class AddLogin_Data extends My_sql{
    
    CheckRegis_Data checkdata = new CheckRegis_Data();

    public void insertData(String username, String email, String password, String firstname, String lastname){
        if (checkdata.CheckEmail(email)|checkdata.CheckUsername(username)){
            System.out.println("Can't add data because it's already have data.");
        }else{
            try {
                super.set_Schema("staff");
                
                super.connect();
                Connection conn = super.get_Connection();
                
                try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + "staff_info" + " (first_name, last_name, email) VALUES (?, ?, ?)")) {
                
                    pstmt.setString(1, firstname);
                    pstmt.setString(2, lastname);
                    pstmt.setString(3, email);
                
                    pstmt.executeUpdate();
                    
                    System.out.println("Add data 1 completed.");
                    
                }
                try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + "staff_login" + " (staff_user, staff_pass) VALUES (?, ?)")){
                    pstmt.setString(1, username);
                    pstmt.setString(2, BCrypt.hashpw(password, BCrypt.gensalt()));
                    
                    pstmt.executeUpdate();
                    
                    System.out.println("Add data 2 completed.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                super.disconnect();
            }
        }
    }
        
    
    public static void main(String[] args) {
        AddLogin_Data t1 = new AddLogin_Data();
        t1.insertData("zedl3all","66070082@kmitl.ac.th","1234","Tanapat","Sanguanwong");
    }
}
