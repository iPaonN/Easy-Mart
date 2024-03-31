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
    private Object[][] dataRows;
    public HistoryController(String username, String projectname){
        this.username = username;
        this.projectname = projectname;
        view = new HistoryView();
        datab = new DoProjectData();
        this.schema = this.projectname;
        this.get_data();
//        dataRows = new Object[][] {{"3/3/2024"}, {"2/3/2024"}, {"1/3/2024"}, {"123"}, {"456"}};
        
        view.displaydata(this.getDataRows());
        
    }
    public UI.View.HistoryView getView() {
        return view;
    }
    
    public void get_data(){
        ArrayList<History> his_data = datab.getAll_Historys(schema);
        HashSet<String> all_date_Set = new HashSet<>();
        for(History i: his_data){
            LocalDateTime LDT = i.getAction_date();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDateTime = LDT.format(formatter);
            all_date_Set.add(formattedDateTime);
        }
        System.out.println(all_date_Set);
    }
    
    
    public ResultSet GetAllData() {
        My_sql sql = new My_sql();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            sql.set_Schema(this.schema);
            sql.connect();
            conn = sql.get_Connection();
            String query = "SELECT action_time FROM history";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
    public Object[][] getDataRows() {
        ResultSet rs = GetAllData();
        List<Object[]> rows = new ArrayList<>();
        try {
            while (rs.next()) {
                String time = rs.getString("action_time");
                Object[] rowData = {time};
                rows.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows.toArray(new Object[rows.size()][]);
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