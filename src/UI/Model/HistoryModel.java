
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
    public ArrayList<Object[]> getDateHis(String time){
        ArrayList<History> allhis = manager.get_Historys_date(this.projectname, time);
        ArrayList<Object[]> result = new ArrayList<Object[]>();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter hour = DateTimeFormatter.ofPattern("HH:mm:ss");
        for (History ah : allhis){
            Object[] his = {ah.getHistory_id()+"", ah.getProduct_id()+"", ah.getProduct_name(), ah.getQuantity(), ah.getType(), ah.getAction(), date.format(ah.getAction_date()), hour.format(ah.getAction_date()), ah.getStaff_user()};
            result.add(his);
        }
        return result;
    }
    
}
