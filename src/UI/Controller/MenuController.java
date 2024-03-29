package UI.Controller;

import My_sql.ProjectData.DoProjectData;
import My_sql.UserData.DoUserData;
import UI.View.MainMenu;


public class MenuController {
    private DoUserData manager;
    private DoProjectData pjm;
    private MainMenu main;
    private String username, projectname;
    
    public MenuController(String username, String projectname){
        manager = new DoUserData();
        pjm = new DoProjectData();
        main = new MainMenu();
        this.username = username;
        this.projectname = projectname;
        main.getCp1().LoadImage(manager.GetProfileImage(this.username));
        main.getUns1().setText(this.username);
    }
}