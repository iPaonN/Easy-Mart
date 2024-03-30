package UI.Model;

import My_sql.My_sql;
import com.mysql.cj.jdbc.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class MemberModel {
    private String username;
    private String role;
    private String projectname;
    Statement stmt = null;
    Connection conn = null;
    public MemberModel() {

    }
    
    public MemberModel(String name, String projectname) {
        this.username = name;
        this.projectname = projectname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setMemberdata(int staff_id, String staff_user, String first_name, String last_name, String email, int staff_access ){
      My_sql sql = new My_sql();
      try{
        sql.set_Schema(this.projectname);
        sql.connect();
        conn = sql.get_Connection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO memberteam (staff_id, staff_user, first_name, last_name, email, staff_access) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, staff_id);
        stmt.setString(2, staff_user);
        stmt.setString(3, first_name);
        stmt.setString(4, last_name);
        stmt.setString(5, email);
        //stmt.setBlob(6, blob);
        stmt.setInt(6, staff_access);
        int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
            System.out.println("A new row was inserted successfully!");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
            sql.disconnect();
        }
    }
    
}
