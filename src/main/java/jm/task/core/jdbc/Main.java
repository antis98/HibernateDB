package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();

        Statement statement = Util.getStatement();

        userService.createUsersTable();

        User user;

        userService.saveUser("Andrey", "Kuznecov", (byte) 28);

        userService.saveUser("Sergey", "Roflanov", (byte) 15);

        userService.saveUser("Oleg", "Antipin", (byte) 54);

        userService.saveUser("Dmitry", "Ponomarenko", (byte) 21);

        ResultSet resultSet = statement.executeQuery("Select * from users");
        while (resultSet.next()) {
            user = new User();

            user.setId(resultSet.getLong(1));
            user.setName(resultSet.getString(2));
            user.setLastName(resultSet.getString(3));
            user.setAge(resultSet.getByte(4));

            System.out.println(user);
        }

        userService.cleanUsersTable();

        String SQL = "DROP TABLE IF EXISTS users";
        statement.executeUpdate(SQL);

        Util.closeConnection();
    }
}
