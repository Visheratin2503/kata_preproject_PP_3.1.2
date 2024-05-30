package SpringBootApps.SpringBootApp1.dao;

import SpringBootApps.SpringBootApp1.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsersList();

    User getUser(int id);

    void addUser(User user);

    void deleteUser(int id);

    void editUser(User user);
}
