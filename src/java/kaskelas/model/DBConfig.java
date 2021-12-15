package kaskelas.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/kaskelas";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    public static Connection openConnection() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            } else {
                try {
                    Class.forName(DRIVER);
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                } catch (ClassNotFoundException | SQLException e) {
                    System.out.println("error conection" + e.getMessage());
                }
                return connection;
            }
        } catch (SQLException ex) {
            if (connection != null && !connection.isClosed()) {
                return connection;
            } else {
                try {
                    Class.forName(DRIVER);
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                } catch (ClassNotFoundException | SQLException e) {
                    System.out.println("error conection" + e.getMessage());
                }
                return connection;
            }
        }
    }
}
