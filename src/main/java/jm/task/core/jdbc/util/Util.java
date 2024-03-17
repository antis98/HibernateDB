package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {

    private static final String USER_NAME = "root";
    private static final String PASSWORD = "750263";
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema";
    static Connection connection;
    static private final Statement statement;


    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement getStatement() {
        return statement;
    }

    public static Connection getConnection() {
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
