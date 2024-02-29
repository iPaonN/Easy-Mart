package My_sql;
import java.sql.*;

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
        } catch (Exception e) {
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
}
