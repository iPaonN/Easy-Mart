package UI.Controller;

import My_sql.My_sql;
import My_sql.ProjectData.DoProjectData;
import My_sql.UserData.DoUserData;
import UI.Model.MemberModel;
import UI.View.AddMember;
import UI.View.Member;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MemberController{
    private String username, projectname;
    private Member view;
    private AddMember adder;
    private MemberModel model;
    private DoProjectData promanager;
    private DoUserData manager;
    

    public MemberController(String username, String projectname) {
        this.username = username;
        this.projectname = projectname;
        view = new Member();
        model = new MemberModel(this.username, this.projectname);
        promanager = new DoProjectData();
        manager = new DoUserData();
        //model.setMemberdata(1, "Staff", "First", "Last", "MAIL", 1);
        view.displaydata(getDataRows());
    }
    

    public Member getView() {
        return view;
    }

    public void setView(Member view) {
        this.view = view;
    }
    
    public ResultSet GetAllData() {
        My_sql sql = new My_sql();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            sql.set_Schema(this.projectname);
            sql.connect();
            conn = sql.get_Connection();
            String query = "SELECT first_name, last_name, staff_access FROM memberteam";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    
    public void displaydata() {
        ResultSet rs = GetAllData();
        try {
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String staffAccess = rs.getString("staff_access");
                System.out.println(firstName + " " + lastName + " " + staffAccess);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Object[][] getDataRows() {
        ResultSet rs = GetAllData();
        List<Object[]> rows = new ArrayList<>();
        try {
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String staffAccess = rs.getString("staff_access");

                String fullName = firstName + " " + lastName;
                Object[] rowData = {fullName, staffAccess};
                rows.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows.toArray(new Object[rows.size()][]);
    }
    
    public static void main(String[] args) {
        new MemberController("Teetat", "Test");
    }
}
