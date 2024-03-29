package UI.Controller;

import My_sql.My_sql;
import UI.Model.MemberModel;
import UI.View.Member;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MemberController{
    private Member view;
    private MemberModel model;

    public MemberController() {
        view = new Member();
        model = new MemberModel();
        model.setMemberdata(1, "Staff", "First", "Last", "MAIL", 1);
        view.displaydata(getDataRows());
    }

    public ResultSet GetAllData() {
        My_sql sql = new My_sql();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            sql.set_Schema("zedl3all_Project1");
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
        new MemberController();
    }
}
