package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {

    private static final String USER_NAME = "root";
    private static final String PASSWORD = "750263";
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema";
    private static Connection connection;

    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;

    }

    static public void closeConnection() {

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
}
