package My_sql;

import java.sql.*;

public class AddLogin extends My_sql{
    public AddLogin() {
        super();
    }

    public AddLogin(String schema, String table) {
        super(schema, table);
    }

    public void insertData(String name, String email){
        try {
            super.connect();
            Connection conn = super.get_Connection();
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + super.get_Table() + " (name, email) VALUES (?, ?)");
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            
            pstmt.executeUpdate();
            
            System.out.println("Add data completed.");
            
            pstmt.close();
            
        } catch (Exception e) {
            e.toString();
        }finally{
            super.disconnect();
        }
            
    }
}
