package My_sql;
import java.sql.*;
import java.util.*;


public class MemberPanel extends My_sql {
    public MemberPanel(){
        super();
    }
    /* Sample How to use
    public static void main(String[] args) {
    MemberPanel memberPanel = new MemberPanel();
    ----
    memberPanel.addMember("1", "tata", "manager");
    */
    public void addMember(String id, String name, String role){
        try {
            super.connect();
            Connection conn = super.get_Connection();
            String sql = "INSERT INTO your_table (id, name, role) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, role);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Member added successfully.");
                } else {
                    System.out.println("Failed to add data.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            super.disconnect();
        }
    }
    
    /* Sample How to use
    public static void main(String[] args) {
    MemberPanel memberPanel = new MemberPanel();
    ----
    memberPanel.getMemberName(0);
    */ 
    public String getMemberName(int index){
        List<String> membername = new ArrayList<>();

    try {
        super.connect();
        Connection conn = super.get_Connection();
        String sql = "SELECT name FROM your_table";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                membername.add(name);
            }
        }
        Collections.sort(membername);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally{
        super.disconnect();
    }

    
    if (index >= 0 && index < membername.size()) {
        return membername.get(index);
    } else {
        return "Invalid index";
    }
    }
    /* Sample How to use
    public static void main(String[] args) {
    MemberPanel memberPanel = new MemberPanel();
    ----
    memberPanel.getRole("tata");
    */ 
    public String getRole(String memberName) {
        String role = null;

        try {
            super.connect();
            Connection conn = super.get_Connection();
            String sql = "SELECT role FROM your_table WHERE name = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, memberName);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        role = resultSet.getString("role");
                    } else {
                        System.out.println("Member not found.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.disconnect();
        }

        return role;
    }
}
