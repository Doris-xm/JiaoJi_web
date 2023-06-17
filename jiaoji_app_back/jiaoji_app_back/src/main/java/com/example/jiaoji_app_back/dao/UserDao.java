package com.example.jiaoji_app_back.dao;

import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.entity.UserAuth;

import java.util.List;

public interface UserDao {

    UserAuth checkUser(String username, String password);
    User getUserByUserId(Integer userId);
    List<User> getAllUsers();
    boolean isAdmin(Integer userId);

}