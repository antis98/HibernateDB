package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Andrey", "Kuznecov", (byte) 28);
        userService.saveUser("Sergey", "Roflanov", (byte) 15);
        userService.saveUser("Oleg", "Antipin", (byte) 54);
        userService.saveUser("Dmitry", "Ponomarenko", (byte) 21);

        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();

        Util.closeConnection();
    }
}
