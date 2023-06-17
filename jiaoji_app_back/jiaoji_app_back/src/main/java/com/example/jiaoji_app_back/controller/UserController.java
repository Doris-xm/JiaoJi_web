package com.example.jiaoji_app_back.controller;

import com.example.jiaoji_app_back.constant.Constant;
import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.entity.UserAuth;
import com.example.jiaoji_app_back.service.UserService;
import com.example.jiaoji_app_back.utils.msgutils.Msg;
import com.example.jiaoji_app_back.utils.msgutils.MsgCode;
import com.example.jiaoji_app_back.utils.msgutils.MsgUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    //public Msg login(@RequestParam(Constant.USERNAME) String username, @RequestParam(Constant.PASSWORD) String password, @RequestParam(Constant.REMEMBER_ME) Boolean remember){
    public User login(@RequestParam(Constant.USER_ID) int userId){
        return userService.getUserByUserId(userId);
    }

    @PostMapping
    @RequestMapping("/checkUsername")
    public Msg CheckUsername(@RequestBody Map<String,Object> params){
        String username = (String) params.get(Constant.USERNAME);
        if(userService.getUserByUserName(username) == null){
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.SUCCESS_MSG);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.ERROR, MsgUtil.SIGN_FAIL_MSG);
        }
    }

    @PostMapping
    @RequestMapping("/newUser")
    public Msg createNewUser(@RequestBody Map<String,Object> params){
        String username = (String) params.get(Constant.USERNAME);
        String password = (String) params.get(Constant.PASSWORD);
        String nickname = (String) params.get(Constant.NICKNAME);
        String mail = (String) params.get(Constant.EMAIL);
        String college = (String) params.get(Constant.COLLEGE);
        String stu_id = (String) params.get(Constant.STU_ID);
        String gender1 =(String) params.get(Constant.GENDER);
        String club = (String) params.get(Constant.CLUB);

        Integer gender = ((gender1.equals("男")))? 1:0;


        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setMail(mail);
        user.setCollege(college);
        user.setClub(club);
        user.setStudentId(stu_id);
        user.setGender(gender);
        if (!userService.createNewUser(user)) {
            return MsgUtil.makeMsg(MsgCode.ERROR, MsgUtil.RESIGN_FAIL_MSG);
        }

        User savedUser = userService.getUserByUserName(username);

        UserAuth userAuth = new UserAuth();
        userAuth.setUsername(username);
        userAuth.setPassword(password);
        userAuth.setUserType(0);
        userAuth.setUserId(savedUser.getUserId());
        if (!userService.createNewUserAuth(userAuth)) {
            return MsgUtil.makeMsg(MsgCode.ERROR, MsgUtil.RESIGN_FAIL_MSG);
        }
        return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.RESIGN_SUCCESS_MSG);
    }

}