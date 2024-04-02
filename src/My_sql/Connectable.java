package My_sql;

import java.sql.Connection;

public interface Connectable {
    public abstract void connect();
    public abstract void disconnect();
    public abstract void set_Schema(String schema);
    public abstract String get_Schema();
    public abstract void set_Table(String table);
    public abstract String get_Table();
    public abstract Connection get_Connection();
}
