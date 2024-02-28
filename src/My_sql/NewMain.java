
package My_sql;

public class NewMain{

    public static void main(String[] args) {
        AddLogin_Data p1 = new AddLogin_Data("sys", "users");
        p1.insertData("zedl3all","66070082@kmitl.ac.th", "1234", "Tanapat", "Sanguanwong");
    }
}
