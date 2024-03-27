package My_sql.ProjectData;
import My_sql.My_sql;
import java.sql.*;


public  class Getdata {
    public static ResultSet getAllData(String username, String projectName) {
    Statement stmt = null;
    Connection conn = null;
    try {
        My_sql sql = new My_sql();
        sql.connect();
        conn = sql.get_Connection();
        stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM " + username + "." + projectName + ".data WHERE username = ? AND projectname = ?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, projectName);
        ResultSet rs = preparedStatement.executeQuery();
        try {
            while (rs.next()) {
                // Iterate through all columns and print their values
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {}
        }
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {}
    }
    return null;
}
    public void Adddata(){
        
    }

}

