package overridetech.jdbc.jpa;

import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan","Ivanov", (byte) 25);
        userService.saveUser("Petr","Petrov", (byte) 26);
        userService.saveUser("Stepan","Stepanov", (byte) 27);
        userService.saveUser("Igor","Igorev", (byte) 28);
        userService.removeUserById(3);
        List<User> users = userService.getAllUsers();
        for (User user : users){
            System.out.println(user.toString());
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
