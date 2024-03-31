package My_sql;

import java.sql.Connection;

public interface Connectable {
    public abstract void connect();
    public abstract void disconnect();
    public void set_Schema(String schema);
    public String get_Schema();
    public void set_Table(String table);
    public String get_Table();
    public Connection get_Connection();
}
