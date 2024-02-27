
package My_sql;

public class NewMain{

    public static void main(String[] args) {
        AddLogin p1 = new AddLogin("sys", "users");
        p1.insertData("zedl3all","66070082@kmitl.ac.th", "1234", "Tanapat", "Sanguanwong");
    }
}
