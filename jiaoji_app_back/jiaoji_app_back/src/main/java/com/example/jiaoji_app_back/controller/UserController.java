package com.example.jiaoji_app_back.controller;

import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("get_user")
    public User getUserByUserId(@RequestBody String jsonData) {
        // 解析 JSON 字符串为 JSON 对象
        JSONObject jsonObject = new JSONObject(jsonData);
        // 获取 userId 字段的值，并将其解析为整数
        Integer userId = jsonObject.getInt("userId");
        return userService.getUserByUserId(userId);
    }

}