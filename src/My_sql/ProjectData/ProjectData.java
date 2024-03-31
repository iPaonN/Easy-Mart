package My_sql.ProjectData;

public sealed abstract class ProjectData permits DoProjectData{
    
    public abstract void Createtemplate(String username, String projectname);
    public abstract void rename_schema(String user, String oldSchema, String newSchema);
    public abstract void delete_project(String username, String projectname);
}
