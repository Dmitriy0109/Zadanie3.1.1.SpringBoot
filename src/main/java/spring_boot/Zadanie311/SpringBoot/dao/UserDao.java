package spring_boot.Zadanie311.SpringBoot.dao;

import spring_boot.Zadanie311.SpringBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();

    User searchById(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}
