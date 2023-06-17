package com.example.jiaoji_app_back.service;

import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.entity.UserAuth;

import java.util.List;


public interface UserService {

    UserAuth checkUser(String username, String password);

    User getUserByUserId(Integer userId);
    List<User> getAllUsers();

    boolean isAdmin(Integer userId);
    User getUserByUserName(String username);
    boolean createNewUser(User user);
    boolean createNewUserAuth(UserAuth userAuth);
}