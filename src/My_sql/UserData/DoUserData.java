
package My_sql.UserData;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;
import java.util.*;
import java.io.*;
import com.google.gson.*;

public final class DoUserData extends UserData{
    
    
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

                DATA.connect();
                Connection conn = DATA.get_Connection();
                
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
                DATA.disconnect();
            }
        }
    }

    @Override
    public boolean CheckLogin(String username, String password) {
        try {
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
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
            DATA.disconnect();
        }
    }

    @Override
    public boolean CheckUsername(String username) {
        try {
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
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
            DATA.disconnect();
        }
    }

    @Override
    public boolean CheckEmail(String email) {
        try {
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
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
            DATA.disconnect();
        }
    }

    @Override
    public void ChangeUsername(String oldusername, String newusername) {
        try{
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_info SET staff_user = ? WHERE staff_user = ?")){
                
                pstmt.setString(1, newusername);
                pstmt.setString(2, oldusername);
                
                pstmt.executeUpdate();
                
                System.out.println("Change Username completed.");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            DATA.disconnect();
        }
    }

    @Override
    public void ChangePassword(String username, String password) {
        try{
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_info SET staff_pass = ? WHERE staff_user = ?")){
                
                pstmt.setString(1, BCrypt.hashpw(password, BCrypt.gensalt()));
                pstmt.setString(2, username);
                
                pstmt.executeUpdate();
                
                System.out.println("Change Password completed.");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            DATA.disconnect();
        }
    }
    
    @Override
    public void ChangeFirstname(String oldfirstname, String newfirstname){
        try{
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_info SET first_name = ? WHERE first_name = ?")){
                
                pstmt.setString(1, newfirstname);
                pstmt.setString(2, oldfirstname);
                
                pstmt.executeUpdate();
                
                System.out.println("Change Username completed.");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            DATA.disconnect();
        }
    }
    
    @Override
    public void ChangeLastname(String oldlastname, String newlastname){
        try{
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_info SET last_name = ? WHERE last_name = ?")){
                
                pstmt.setString(1, newlastname);
                pstmt.setString(2, oldlastname);
                
                pstmt.executeUpdate();
                
                System.out.println("Change Username completed.");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            DATA.disconnect();
        }
    }
    
    @Override
    public void ChangeProfileImage(String username, File pathFile){
        try{
            FileInputStream inputStream = new FileInputStream(pathFile);
            
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_info SET image = ? WHERE staff_user = ?")){
                
                pstmt.setBinaryStream(1, inputStream);
                pstmt.setString(2, username);
                
                pstmt.executeUpdate();
                
                System.out.println("Change Image completed.");
                
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }finally{
            DATA.disconnect();
        }
    }
    
    @Override
    public File GetProfileImage(String username){
        File imgFile = null;
        try{
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT image FROM staff_info WHERE staff_user = ?")){
                
                pstmt.setString(1, username);
                
                ResultSet rs = pstmt.executeQuery();
                
                if(rs.next()){
                    InputStream is = rs.getBinaryStream("image");
                    
                    imgFile = new File("Profile_image_"+username+".png");
                    
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
            DATA.disconnect();
            return imgFile;
        }
    }
    
    
    @Override
    public ArrayList<String> GetProjectList(String username){
        ArrayList<String> projectList = new ArrayList<>();
        try{
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT project FROM staff_info WHERE staff_user = ?")){
                
                pstmt.setString(1, username);
                
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    projectList.add(rs.getString("project"));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            DATA.disconnect();
            return projectList;
        }
    }
    
    @Override
    public void UpdataProjectList(String username, ArrayList<String> projectList){
        Gson gson = new Gson();
        String projecString = gson.toJson(projectList);
        
        try{
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_info SET project = ? WHERE staff_user = ?")){
                
                pstmt.setString(1, projecString);
                pstmt.setString(2, username);
                
                pstmt.executeUpdate();
                
                System.out.println("Update project completed.");
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            DATA.disconnect();
        }
    }
    
    //Overload
    public void UpdataProjectList(String username, ArrayList<String> projectList, String project){
        
        projectList.removeIf(item -> item == null);
        projectList.add(project);
        
        ArrayList<String> newprojecList = new ArrayList<>();
        
        for (int i = 0; i < projectList.size(); i++) {
            String current = projectList.get(i);
            current = current.replace("[","").replace("]","").replace("\\","").replace("\"","");
            String[] splitStrings = current.split(",");
            newprojecList.addAll(Arrays.asList(splitStrings));
        }
        
        Gson gson = new Gson();
        String projecString = gson.toJson(newprojecList);
        
        try{
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("UPDATE staff_info SET project = ? WHERE staff_user = ?")){
                
                pstmt.setString(1, projecString);
                pstmt.setString(2, username);
                
                pstmt.executeUpdate();
                
                System.out.println("Update project completed.");
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            DATA.disconnect();
        }
    }
    
//    public static void main(String[] args) {
//        DoUserData t1 = new DoUserData();
//        //t1.InsertData("Test1", "Test1@gmail.com", "1234", "Test", "Test");
//        ArrayList l1 = t1.GetProjecList("Test1");
//        t1.UpdataProjectList("Test1", l1,"Hello4");
//    }
}
