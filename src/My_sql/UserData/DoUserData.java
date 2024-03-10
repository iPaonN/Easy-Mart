
package My_sql.UserData;

import My_sql.My_sql;
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;
import java.util.*;
import java.io.*;

public class DoUserData extends UserData{
    
    private My_sql data = new My_sql("staff","");
    
    @Override
    public void InsertData(String username, String email, String password, String firstname, String lastname) {
        if (this.CheckEmail(email)|this.CheckUsername(username)){
            System.out.println("Can't add data because it's already have data.");
        }else{
            try {
                
                Random random = new Random();
                int random_number = random.nextInt(4)+1;
                
                File imageFile = new File("src/My_sql/UserData/Image/image"+random_number+".png");
                FileInputStream inputStream = new FileInputStream(imageFile);

                data.connect();
                Connection conn = data.get_Connection();
                
                try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + "staff_info" + " (staff_user, staff_pass, first_name, last_name, email, image) VALUES (?, ?, ?, ?, ?, ?)")) {
                    
                    pstmt.setString(1, username);
                    pstmt.setString(2, BCrypt.hashpw(password, BCrypt.gensalt()));
                    pstmt.setString(3, firstname);
                    pstmt.setString(4, lastname);
                    pstmt.setString(5, email);
                    pstmt.setBinaryStream(6, inputStream);
                
                    pstmt.executeUpdate();
                    
                    System.out.println("Add data completed.");
                    
                }
            } catch (IOException | SQLException e) {
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
            
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM staff_info WHERE staff_user = ?")){
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
            
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM staff_info WHERE staff_user = ?")){
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
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_info SET staff_user = ? WHERE staff_user = ?")){
                
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
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_info SET staff_pass = ? WHERE staff_user = ?")){
                
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
    
    @Override
    public void ChangeFirstname(String oldfirstname, String newfirstname){
        try{
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_info SET first_name = ? WHERE first_name = ?")){
                
                pstmt.setString(1, newfirstname);
                pstmt.setString(2, oldfirstname);
                
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
    public void ChangeLastname(String oldlastname, String newlastname){
        try{
            data.connect();
            Connection conn = data.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_info SET last_name = ? WHERE last_name = ?")){
                
                pstmt.setString(1, newlastname);
                pstmt.setString(2, oldlastname);
                
                pstmt.execute();
                
                System.out.println("Change Username completed.");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            data.disconnect();
        }
    }
    
    public static void main(String[] args) {
        DoUserData t1 = new DoUserData();
        t1.InsertData("Test1", "test1gmail.com", "1234", "test1", "1test");
    }
}
