
package My_sql;

public class NewMain{

    public static void main(String[] args) {
        CheckLogin_Data p1 = new CheckLogin_Data("sys", "users");
        System.out.println(p1.CheckData("Pao", "456"));
    }
}
