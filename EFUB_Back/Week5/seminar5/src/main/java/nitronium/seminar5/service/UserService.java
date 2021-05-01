package nitronium.seminar5.service;

import nitronium.seminar5.dao.UserDao;
import nitronium.seminar5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired // 생성자 및 세터를 사용하여 의존성 주입
    UserDao userDao;

    public List<User> getAllUsers() { return userDao.getAllUsers(); }

    public User getUserByUserId(String userId) {
        return userDao.getUserByUserId(userId);
    }

    public User registerUser(User user) { return userDao.insertUser(user); }

    public void modifyUser(String userId, User user) { userDao.updateUser(userId, user); }

    public void removeUser(String userId) { userDao.deleteUser(userId); }
}
