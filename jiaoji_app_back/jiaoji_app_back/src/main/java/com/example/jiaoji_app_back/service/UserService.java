package com.example.jiaoji_app_back.service;

import com.example.jiaoji_app_back.entity.UserAuth;


public interface UserService {

    UserAuth checkUser(String username, String password);
}
