package overridetech.jdbc.jpa.service;

import overridetech.jdbc.jpa.dao.UserDaoHibernateImpl;
import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.util.Util;

import java.sql.SQLException;
import java.util.List;

public class UserServiceHibernateimpl implements UserService {
    Util util = new Util();

    private final UserDaoHibernateImpl userDaoHibernate;

    public UserServiceHibernateimpl() {
        this.userDaoHibernate = new UserDaoHibernateImpl(util.getSessionFactory());
    }

    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
    }
}
