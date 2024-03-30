
package My_sql.UserData;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;
import java.util.*;
import java.io.*;
import com.google.gson.*;
import java.awt.Image;
import javax.imageio.ImageIO;

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
    public Image GetProfileImage(String username){
        Image imgFile = null;
        try{
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
            try(PreparedStatement pstmt = conn.prepareStatement("SELECT image FROM staff_info WHERE staff_user = ?")){
                
                pstmt.setString(1, username);
                
                ResultSet rs = pstmt.executeQuery();
                
                if(rs.next()){
                    Blob blob = rs.getBlob("image");
                    
                    byte[] imageData = blob.getBytes(1, (int) blob.length());
                    
                    imgFile = ImageIO.read(new ByteArrayInputStream(imageData));
                    
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
                    
                    String preout = rs.getString("project");
                    
                    String current = preout.replace("[","").replace("]","").replace("\\","").replace("\"","");
                    current = current.trim();
                    
                    String[] splitStrings = current.split(",");
                    
                    for(String i:splitStrings){
                        i = i.trim();
                        projectList.add(i);
                    }
                    
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
    public void UpdateProjectList(String username, ArrayList<String> projectList){
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
    public void UpdateProjectList(String username, ArrayList<String> projectList, String project){
        
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
    
    public void RemoveProject(String username, String project_name){
        ArrayList<String> projectList = this.GetProjectList(username);
        
        if(projectList.contains(project_name)){
            projectList.remove(project_name);
            this.UpdateProjectList(username, projectList);
        }else{
            System.out.println("Don't have project.");
        }
    }
    
    public void RenameProject(String username, String old_project, String new_project){
        ArrayList<String> projectList = this.GetProjectList(username);
        
        int index = projectList.indexOf(old_project);
        
        if (index != -1){
            projectList.set(index, new_project);
            this.UpdateProjectList(username, projectList);
            System.out.println("rename completed.");
        }else{
            System.out.println("can't find project");
        }
    }
    
    public User Get_User(String username){
        User user = new User();
        
        try{
            DATA.connect();
            Connection conn = DATA.get_Connection();
            
            try(PreparedStatement get_pstmt = conn.prepareStatement("SELECT * FROM staff_info WHERE staff_user = ?")){
            
                get_pstmt.setString(1, username);
                
                ResultSet rs = get_pstmt.executeQuery();
                
                while(rs.next()){
                    user.setUser_name(rs.getString("staff_user"));
                    user.setFirst_name(rs.getString("first_name"));
                    user.setLast_name(rs.getString("last_name"));
                    user.setEmail("email");
                    user.setImage(rs.getBlob("image"));
                }
            }
        
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            DATA.disconnect();
            return user;
        }
    }
    
//    public static void main(String[] args) {
//        DoUserData t1 = new DoUserData();
//        //t1.InsertData("Test1", "Test1@gmail.com", "1234", "Test", "Test");
//        ArrayList l1 = t1.GetProjectList("Test1");
//        System.out.println(l1);
//        t1.RemoveProject("Test1", "Hello4");
//        l1 = t1.GetProjectList("Test1");
//        System.out.println(l1);
//        ///t1.UpdataProjectList("Test1", l1,"Hello4");
//    }
}
