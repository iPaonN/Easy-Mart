
package UI.Model;

import My_sql.ProjectData.DoProjectData;
import My_sql.ProjectData.History;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HistoryModel {
    private String username, projectname;
    private DoProjectData manager;

    public HistoryModel(String username, String projectname) {
        this.username = username;
        this.projectname = projectname;
        manager = new DoProjectData();
    }
    
    public ArrayList<String> getFirstHis(){
        ArrayList<History> allhis = manager.getAll_Historys(this.projectname);
        ArrayList<String> result = new ArrayList<String>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (History ah: allhis){
            String rt = dtf.format(ah.getAction_date());
            if(result.contains(rt) == false){
                result.add(rt);
            }
        }
        return result;
    }
    
    
}
