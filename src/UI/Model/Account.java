package UI.Model;
import My_sql.UserData.DoUserData;
import java.util.ArrayList;

public class Account {
    private String username;
    private DoUserData manager = new DoUserData();
    public Account(String username){
        this.username = username;
    }
    public Account(){
        this.username = "";
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public ArrayList<String> getProjectList(){
        //return this.manager.GetProjecList(this.username);
        ArrayList<String> ex = new ArrayList();
        ex.add("First");
        ex.add("Test");
        return ex;
    }
    public boolean checkProjectName(String projectname){
        char[] charArray = projectname.toCharArray();
        for(char c:charArray){
            if (!Character.isLetterOrDigit(c))
                return false;
            }
        return true;
    }
    public void createProject(String projectname){
        
    }
    
    
    
}
