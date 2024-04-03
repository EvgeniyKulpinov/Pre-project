package overridetech.jdbc.jpa.service;

import overridetech.jdbc.jpa.dao.UserDaoJDBCImpl;
import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.util.Util;

import java.sql.SQLException;
import java.util.List;

public class UserServiceJDBSImpl implements UserService {

    private final UserDaoJDBCImpl userDaoJDBC;


    public UserServiceJDBSImpl() {
        this.userDaoJDBC = new UserDaoJDBCImpl(Util.getPostgreSQLConnection());
    }

    public void createUsersTable() throws SQLException {
        userDaoJDBC.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userDaoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDaoJDBC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        userDaoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        userDaoJDBC.cleanUsersTable();
    }
}
