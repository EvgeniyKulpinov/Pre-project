package overridetech.jdbc.jpa.service;

import overridetech.jdbc.jpa.dao.UserDaoJDBCImpl;
import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final Connection connection;

    public UserServiceImpl() {
        this.connection = Util.getPostgreSQLConnection();
    }

    public void createUsersTable() throws SQLException {
        new UserDaoJDBCImpl(connection).createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        new UserDaoJDBCImpl(connection).dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        new UserDaoJDBCImpl(connection).saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        new UserDaoJDBCImpl(connection).removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return new UserDaoJDBCImpl(connection).getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        new UserDaoJDBCImpl(connection).cleanUsersTable();
    }
}
