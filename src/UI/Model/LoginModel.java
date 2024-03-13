package Event.Model;

import java.io.Serializable;

public class LoginModel implements Serializable{
    private String username;
    private boolean statuscheck;
    public LoginModel(){
        this("", false);
    }
    public LoginModel(String name, boolean check){
        this.username = name;
        this.statuscheck = check;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public boolean isStatuscheck() {
        return statuscheck;
    }
    public void setStatuscheck(boolean statuscheck) {
        this.statuscheck = statuscheck;
    }
}
