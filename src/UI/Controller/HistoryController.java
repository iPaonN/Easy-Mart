package UI.Controller;
import My_sql.My_sql;
import UI.View.HistoryView;
import UI.View.ViewHistory;
import java.io.*;
import java.awt.event.*;
//import java.awt.*;
import My_sql.ProjectData.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class HistoryController {
    private String username, projectname, schema;
    private HistoryView view;
    private DoProjectData datab;
    private ArrayList<Object> data_array;
    public HistoryController(String username, String projectname){
        this.username = username;
        this.projectname = projectname;
        view = new HistoryView();
        datab = new DoProjectData();
        this.schema = this.projectname;
//        dataRows = new Object[][] {{"3/3/2024"}, {"2/3/2024"}, {"1/3/2024"}, {"123"}, {"456"}};
        
        view.displaydata(this.getDataRows(this.get_data()));
        
    }
    public UI.View.HistoryView getView() {
        return view;
    }
    
    public HashSet<String> get_data(){
        ArrayList<History> his_data = datab.getAll_Historys(schema);
        HashSet<String> all_date_Set = new HashSet<>();
        for(History i: his_data){
            LocalDateTime LDT = i.getAction_date();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDateTime = LDT.format(formatter);
            all_date_Set.add(formattedDateTime);
        }
        System.out.println(all_date_Set);
        return all_date_Set;
    }

    public Object[][] getDataRows(HashSet<String> date_set) {
        for (String i : date_set){
            data_array.add(new Object[]{i});
        }
        Object[][] dataRows = data_array.toArray(new Object[data_array.size()][]);
        return dataRows;
    }
  
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new HistoryController("zedl3all", "zedl3all_pj1");
        });
    }
}