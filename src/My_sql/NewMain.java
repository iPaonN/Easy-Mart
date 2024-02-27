
package My_sql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewMain{

    public static void main(String[] args) {
        AddLogin p1 = new AddLogin("sys", "User");
        p1.insertData("Tanapat Sanguanwong", "66070082@kmitl.ac.th");
    }
}
