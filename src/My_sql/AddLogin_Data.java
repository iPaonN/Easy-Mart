package My_sql;

import java.sql.*;

public class AddLogin_Data extends My_sql{
    public AddLogin_Data() {
        super();
    }

    public AddLogin_Data(String schema, String table) {
        super(schema, table);
    }

    public void insertData(String username, String email, String password, String firstname, String lastname){
        try {
            super.connect();
            Connection conn = super.get_Connection();
            
            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + super.get_Table() + " (username, email, password, firstname, lastname) VALUES (?, ?, ?, ?, ?)")) {
                pstmt.setString(1, username);
                pstmt.setString(2, email);
                pstmt.setString(3, BCrypt.hashpw(password, BCrypt.gensalt()));
                pstmt.setString(4, firstname);
                pstmt.setString(5, lastname);
                
                pstmt.executeUpdate();

                System.out.println("Add data completed.");
                
                pstmt.close();
                System.out.println("Disconnect PreparedStatement.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            super.disconnect();
        }
            
    }
}
