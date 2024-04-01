package UI.Model;

import My_sql.ProjectData.DoProjectData;

public class CashModel {
    private String username, projectname;
    private DoProjectData manager;

    public CashModel(String username, String projectname) {
        this.username = username;
        this.projectname = projectname;
        manager = new DoProjectData();
        
    }
    
}
