package spring_boot.Zadanie311.SpringBoot.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_boot.Zadanie311.SpringBoot.dao.UserDao;
import spring_boot.Zadanie311.SpringBoot.model.User;


import java.util.List;
@Component
public class UsersServises implements UserServis {
    private final UserDao usersDao;
    @Autowired
    public UsersServises(UserDao usersDao){
        this.usersDao=  usersDao;
    }
    public List<User> allUsers() {
        return usersDao.allUsers();
    }
    public User searchById(int id) {
        return usersDao.searchById(id);
    }
    public void save(User user) {
        usersDao.save(user);
    }
    public void update(int id, User user) {
        usersDao.update(id,user);
    }
    public void delete(int id){
        usersDao.delete(id);
    }
}
