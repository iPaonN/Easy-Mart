package My_sql.UserData;

import My_sql.My_sql;
import java.awt.Image;
import java.io.*;
import java.util.*;

public sealed abstract class UserData permits DoUserData{
    
    public final My_sql DATA = new My_sql("staff","");
    
    public abstract void InsertData(String username, String email, String password, String firstname, String lastname);
    public abstract boolean CheckLogin(String username, String password);
    public abstract boolean CheckUsername(String username);
    public abstract boolean CheckEmail(String email);
    public abstract void ChangeUsername(String oldusername, String newusername);
    public abstract void ChangePassword(String username, String password);
    public abstract void ChangeFirstname(String oldfirstname, String newfirstname);
    public abstract void ChangeLastname(String oldlastname, String newlastname);
    public abstract void ChangeProfileImage(String username, File pathFile);
    public abstract Image GetProfileImage(String username);
    public abstract ArrayList<String> GetProjectList(String username);
    public abstract void UpdateProjectList(String username, ArrayList<String> projectList);
    public abstract void RemoveProject(String username, String project_name);
    public abstract void RenameProject(String username, String old_project, String new_project);
    
}
