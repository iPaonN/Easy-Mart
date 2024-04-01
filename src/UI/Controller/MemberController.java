package UI.Controller;

import My_sql.My_sql;
import My_sql.ProjectData.DoProjectData;
import My_sql.UserData.DoUserData;
import UI.Model.MemberModel;
import UI.View.AddMember;
import UI.View.MemberView;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.event.*;

public class MemberController implements ActionListener{
    private String username, projectname;
    private MemberView view;
    private AddMember adder;
    private MemberModel model;
    private DoProjectData promanager;
    private DoUserData manager;
    

    public MemberController(String username, String projectname) {
        this.username = username;
        this.projectname = projectname;
        view = new MemberView();
        model = new MemberModel(this.username, this.projectname);
        promanager = new DoProjectData();
        manager = new DoUserData();
        //model.setMemberdata(1, "Staff", "First", "Last", "MAIL", 1);
        view.displaydata(this.getDataRows());
        
        //Add Listener
        view.getAdd().addActionListener(this);
    }
    

    public MemberView getView() {
        return view;
    }

    public void setView(MemberView view) {
        this.view = view;
    }
    public String getNameAdder(String email){
        try{
            ResultSet rs = promanager.getRS("staff", "staff_info");
            return promanager.getStringdata(rs, "email", email, "staff_user");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
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
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getAdd())){
            adder = new AddMember();
            adder.getJcb1().addItem("Manager");
            adder.getJcb1().addItem("Member");
            adder.getBadd().addActionListener(this);
        }
        else if (e.getSource().equals(adder.getBadd())){
            if (adder.getTfemial().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter email.");
            }
            else if (manager.CheckEmail(adder.getTfemial().getText()) == false){
                adder.getJalert().setText("Don't have this email");
                adder.getTfemial().setText("");
            }
            else if ((((String)adder.getJcb1().getSelectedItem()).equals("Manager") == false)||(((String)adder.getJcb1().getSelectedItem()).equals("Member") == false)){
                JOptionPane.showMessageDialog(null, "Please Select Role");
            }
            else {
                String nmem = this.getNameAdder(adder.getTfemial().getText());
                promanager.insert_member(this.projectname, nmem, (String)adder.getJcb1().getSelectedItem());
                manager.UpdateProjectList(nmem, manager.GetProjectList(nmem), this.projectname);
                adder.getMainf().dispose();
            }
        }
    }
    
//    public static void main(String[] args) {
//        new MemberController("Teetat", "Teetat_b");
//    }
}
