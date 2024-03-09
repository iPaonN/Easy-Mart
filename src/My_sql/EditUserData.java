
package My_sql;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class EditUserData extends UserData{
    
    private My_sql data = new My_sql("staff","");
    
    @Override
    public void InsertData(String username, String email, String password, String firstname, String lastname) {
        if (this.CheckEmail(email)|this.CheckUsername(username)){
            System.out.println("Can't add data because it's already have data.");
        }else{
            try {
                data.connect();
                Connection conn = data.get_Connection();
                
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
                data.disconnect();
            }
        }
    }

    @Override
    public boolean CheckLogin(String username, String password) {
        try {
            data.connect();
            Connection conn = data.get_Connection();
            
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM staff_login WHERE staff_user = ?")){
                pstmt.setString(1, username);
                
                try(ResultSet rs = pstmt.executeQuery()){
                    
                    if (rs.next()){
                        
                        String gethashingpassword = rs.getString("staff_pass");
                        
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
            data.disconnect();
        }
    }

    @Override
    public boolean CheckUsername(String username) {
        try {
            data.connect();
            Connection conn = data.get_Connection();
            
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
            data.disconnect();
        }
    }

    @Override
    public boolean CheckEmail(String email) {
        try {
            data.connect();
            Connection conn = data.get_Connection();
            
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
            data.disconnect();
        }
    }

    @Override
    public void ChangeUsername(String oldusername, String newusername) {
        try{
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_login SET staff_user = ? WHERE staff_user = ?")){
                
                pstmt.setString(1, newusername);
                pstmt.setString(2, oldusername);
                
                pstmt.execute();
                
                System.out.println("Change Username completed.");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }

    @Override
    public void ChangePassword(String username, String password) {
        try{
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_login SET staff_pass = ? WHERE staff_user = ?")){
                
                pstmt.setString(1, BCrypt.hashpw(password, BCrypt.gensalt()));
                pstmt.setString(2, username);
                
                pstmt.execute();
                
                System.out.println("Change Password completed.");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
//    public static void main(String[] args) {
//        EditUserData t1 = new EditUserData();
//        t1.ChangePassword("Ball", "456");
//        t1.CheckLogin("Ball", "456");
//    }
}
