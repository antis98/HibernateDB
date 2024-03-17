package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    Statement statement = Util.getStatement();

    public void createUsersTable() {

        try {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users ("
                    + "id int auto_increment primary key, "
                    + "name varchar(30), "
                    + "last_name varchar(30), "
                    + "age int)"
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {

        String SQL = "DROP TABLE IF EXISTS users";
        try {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {

        try {
            statement.executeUpdate("INSERT INTO users (name, last_name, age) value ('" + name + "', '" + lastName + "', " + age + ")");
            System.out.println("User с именем — " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeUserById(long id) {

        try {
            statement.executeUpdate("DELETE FROM users WHERE id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";
        try (PreparedStatement preparedStatements = Util.getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatements.executeQuery()
        ) {
            while (resultSet.next()) {
                User user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getByte(4));

                users.add(user);

                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;

    }

    public void cleanUsersTable() {

        try {
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
