
package My_sql.UserData;
import java.sql.*;

public class User {
    private String user_name;
    private String first_name;
    private String last_name;
    private String email;
    private Blob image;

    public User(){
    
    }

    public User(String user_name, String first_name, String last_name, String email, Blob image) {
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.image = image;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
    
    
    
}
