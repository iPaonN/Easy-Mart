package My_sql.UserData;

import My_sql.My_sql;

public abstract class UserData extends My_sql{
    
    public abstract void InsertData(String username, String email, String password, String firstname, String lastname);
    public abstract boolean CheckLogin(String username, String password);
    public abstract boolean CheckUsername(String username);
    public abstract boolean CheckEmail(String email);
    public abstract void ChangeUsername(String oldusername, String newusername);
    public abstract void ChangePassword(String username, String password);
    
}
