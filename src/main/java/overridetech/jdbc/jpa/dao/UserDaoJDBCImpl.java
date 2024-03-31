package overridetech.jdbc.jpa.dao;

import overridetech.jdbc.jpa.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection;

    public UserDaoJDBCImpl(Connection connection) {
        this.connection = connection;
    }

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists users"
                + " (id serial primary key,"
                + " name varchar(255) not null,"
                + " lastName varchar(255) not null,"
                + " age integer not null)");
        stmt.close();
    }

    public void dropUsersTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("drop table if exists users");
        stmt.close();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String sql = "insert into users (name, lastName, age) values (?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, lastName);
        stmt.setByte(3, age);
        stmt.executeUpdate();
        stmt.close();
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) throws SQLException {
        String sql = "delete from users where id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public List<User> getAllUsers() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("select * from users");
        ResultSet result = stmt.getResultSet();
        List<User> users = new ArrayList<>();
        while (result.next()) {
            User user = new User(result.getString(2),
                    result.getString(3),
                    result.getByte(4));
            user.setId(result.getLong(1));
            users.add(user);
        }
        result.close();
        stmt.close();
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("delete from users");
        stmt.close();
    }
}
