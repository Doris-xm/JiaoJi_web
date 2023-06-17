package com.example.jiaoji_app_back.serviceimpl;

import com.example.jiaoji_app_back.dao.UserDao;
import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.entity.UserAuth;
import com.example.jiaoji_app_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserAuth checkUser(String username, String password){
        return userDao.checkUser(username,password);
    }

    @Override
    public User getUserByUserId(Integer userId) {
        return userDao.getUserByUserId(userId);
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    public boolean isAdmin(Integer userId) {
        return userDao.isAdmin(userId);
    }
    @Override
    public User getUserByUserName(String username) {
        return userDao.getUserByUserName(username);
    }
    @Override
    public boolean createNewUser(User user) {
        return userDao.createNewUser(user);
    }
    @Override
    public boolean createNewUserAuth(UserAuth userAuth) {
        return userDao.createNewUserAuth(userAuth);
    }
    @Override
    public UserAuth getUserAuthByUserId(Integer userId) {
        return userDao.getUserAuthByUserId(userId);
    }
}
