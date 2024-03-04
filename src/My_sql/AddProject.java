package My_sql;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddProject extends My_sql {
    public AddProject() {
        super();
    }

    public void addData(String id, String name) {
        try {
            super.connect();
            Connection conn = super.get_Connection();
            String sql = "INSERT INTO your_table (id, name) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, name);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data added successfully.");
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
    /* Sample how to use
    public static void main(String[] args) {
        AddProject addProject = new AddProject();
        addProject.addData("123", "Example Project");
    }
    */
    
    public String getData(int index) {
    List<String> data = new ArrayList<>();

    try {
        super.connect();
        Connection conn = super.get_Connection();
        String sql = "SELECT name FROM your_table";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                data.add(name);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally{
        super.disconnect();
    }

    
    if (index >= 0 && index < data.size()) {
        return data.get(index);
    } else {
        return "Invalid index";
    }
    /* Sample how to use
    public static void main(String[] args) {
        AddProject addProject = new AddProject();
        String project_name1 = addProject.getData(0);
    }
    */
}
}
