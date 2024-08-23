package controllers.dbConnection;

import javafx.beans.property.Property;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static DBConnection dbConnection;

    final private static String URL ="jdbc:mysql://localhost:3306/MyProject" ;

    private final static Properties props = new Properties();

    private Connection connection;

    static {
        props.setProperty("user","root");
        props.setProperty("password","1234");
    }

     private  DBConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, props);
    }

    public static DBConnection getInstance() throws SQLException {
        return (dbConnection == null) ? dbConnection = new DBConnection() : dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
