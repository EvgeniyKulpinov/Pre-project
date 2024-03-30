package overridetech.jdbc.jpa.dao;

import overridetech.jdbc.jpa.executor.Executor;
import overridetech.jdbc.jpa.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Executor executor;

    public UserDaoJDBCImpl(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        executor.execUpdate("create table if not exists users"
                + " (id serial primary key,"
                + " name varchar(255) not null,"
                + " lastName varchar(255) not null,"
                + " age integer not null)");
    }

    public void dropUsersTable() throws SQLException {
        executor.execUpdate("drop table if exists users");
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        executor.execUpdate("insert into users (name, lastName, age)"
                + " values ('" + name + "','" + lastName + "','" + age + "')");
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) throws SQLException {
        executor.execUpdate("delete from users where id = '" + id + "'");
    }

    public List<User> getAllUsers() throws SQLException {
        return executor.execQuery("select * from users", result -> {
            List<User> users = new ArrayList<>();
            while (result.next()) {
                User user = new User(result.getString(2),
                        result.getString(3),
                        (byte) result.getInt(4));
                user.setId(result.getLong(1));
                users.add(user);
            }
            return users;
        });
    }

    public void cleanUsersTable() throws SQLException {
        executor.execUpdate("delete from users");
    }
}
