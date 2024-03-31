package UI.Model;

public class DashBoardModel {
    private String username;
    private String projectname;
    
    public DashBoardModel(String name, String projectname){
        this.username = name;
        this.projectname = projectname;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}