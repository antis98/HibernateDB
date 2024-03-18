package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Andrey", "Kuznecov", (byte) 28);

        userService.saveUser("Sergey", "Roflanov", (byte) 15);

        userService.saveUser("Oleg", "Antipin", (byte) 54);

        userService.saveUser("Dmitry", "Ponomarenko", (byte) 21);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

        Util.closeConnection();
    }
}
