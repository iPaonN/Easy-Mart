package My_sql.ProjectData;

public sealed abstract class ProjectData permits DoProjectData{
    
    public abstract void Createtemplate(String username, String projectname);
}
