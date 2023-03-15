package studetnt.jdbc;

import java.sql.SQLException;

public interface StudentOperations {
    public String addDetails();
    public void display();
    public void makeConnection() throws SQLException;
}
