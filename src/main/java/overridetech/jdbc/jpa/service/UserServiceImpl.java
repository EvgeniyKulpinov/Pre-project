package overridetech.jdbc.jpa.service;

import org.hibernate.SessionFactory;
import overridetech.jdbc.jpa.dao.UserDaoHibernateImpl;
import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    Util util = new Util();

    private final Connection connection;
    private final SessionFactory sessionFactory;

    public UserServiceImpl() {
        this.connection = Util.getPostgreSQLConnection();
        this.sessionFactory = util.getSessionFactory();
    }

    public void createUsersTable() throws SQLException {
//        new UserDaoJDBCImpl(connection).createUsersTable();
        new UserDaoHibernateImpl(sessionFactory).createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
//        new UserDaoJDBCImpl(connection).dropUsersTable();
        new UserDaoHibernateImpl(sessionFactory).dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
//        new UserDaoJDBCImpl(connection).saveUser(name, lastName, age);
        new UserDaoHibernateImpl(sessionFactory).saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
//        new UserDaoJDBCImpl(connection).removeUserById(id);
        new UserDaoHibernateImpl(sessionFactory).removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
//        return new UserDaoJDBCImpl(connection).getAllUsers();
        return new UserDaoHibernateImpl(sessionFactory).getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
//        new UserDaoJDBCImpl(connection).cleanUsersTable();
        new UserDaoHibernateImpl(sessionFactory).cleanUsersTable();
    }
}
