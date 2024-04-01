package overridetech.jdbc.jpa.service;

import overridetech.jdbc.jpa.dao.UserDaoHibernateImpl;
import overridetech.jdbc.jpa.dao.UserDaoJDBCImpl;
import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.util.Util;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    Util util = new Util();

    private final UserDaoJDBCImpl userDaoJDBC;
    private final UserDaoHibernateImpl userDaoHibernate;

    public UserServiceImpl() {
        this.userDaoJDBC = new UserDaoJDBCImpl(Util.getPostgreSQLConnection());
        this.userDaoHibernate = new UserDaoHibernateImpl(util.getSessionFactory());
    }

    public void createUsersTable() throws SQLException {
//        userDaoJDBC.createUsersTable();
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
//        userDaoJDBC.dropUsersTable();
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
//        userDaoJDBC.saveUser(name, lastName, age);
        userDaoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
//        userDaoJDBC.removeUserById(id);
        userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
//        userDaoJDBC.getAllUsers();
        return userDaoHibernate.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
//        userDaoJDBC.cleanUsersTable();
        userDaoHibernate.cleanUsersTable();
    }
}
