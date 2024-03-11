package My_sql.UserData;

import My_sql.My_sql;
import java.io.*;
import java.util.*;

public abstract class UserData extends My_sql{
    
    public abstract void InsertData(String username, String email, String password, String firstname, String lastname);
    public abstract boolean CheckLogin(String username, String password);
    public abstract boolean CheckUsername(String username);
    public abstract boolean CheckEmail(String email);
    public abstract void ChangeUsername(String oldusername, String newusername);
    public abstract void ChangePassword(String username, String password);
    public abstract void ChangeFirstname(String oldfirstname, String newfirstname);
    public abstract void ChangeLastname(String oldlastname, String newlastname);
    public abstract void ChangeProfileImage(String username, File pathFile);
    public abstract ArrayList<String> GetProjecList(String username);
    public abstract void UpdataProjectList(String username, ArrayList<String> projectList);
    
}
