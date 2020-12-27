package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {

    private static String dbDriver = "com.mysql.jdbc.Driver";
    private static String dbURL = "jdbc:mysql://localhost:3306/";
    private static String dbName = "MovieWeb";
    private static String dbUsername = "root";
    private static String dbPassword = "root";

    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        Class.forName(dbDriver);
        Connection conn = DriverManager.getConnection(dbURL+dbName, dbUsername, dbPassword);
        return conn;
    }

}
