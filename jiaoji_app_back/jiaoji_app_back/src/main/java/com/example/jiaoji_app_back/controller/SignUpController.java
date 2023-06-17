//package com.example.jiaoji_app_back.controller;
//
//import com.example.jiaoji_app_back.constant.Constant;
//import com.example.jiaoji_app_back.entity.UserAuth;
//import com.example.jiaoji_app_back.service.SignUpService;
//import com.example.jiaoji_app_back.utils.msgutils.Msg;
//import com.example.jiaoji_app_back.utils.msgutils.MsgCode;
//import com.example.jiaoji_app_back.utils.msgutils.MsgUtil;
//import com.example.jiaoji_app_back.utils.sessionutils.SessionUtil;
//import net.sf.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.File;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//public class SignUpController {
//
//    @Autowired
//    private SignUpService signUpService;
//    @PostMapping
//    @RequestMapping("/signup")
//    @ResponseStatus(HttpStatus.OK)
//    public Msg login(@RequestBody Map<String, String> params){
//        String userId = params.get(Constant.USER_ID);
//        String actId = params.get(Constant.ACT_ID);
//
//        if(signUpService.SignUp(Integer.parseInt(userId),Integer.parseInt(actId))){
//            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.SIGNUP_SUCCESS_MSG);
//        }else{
//            return MsgUtil.makeMsg(MsgCode.ERROR);
//        }
//    }
//}
package com.example.jiaoji_app_back.controller;

import com.example.jiaoji_app_back.constant.Constant;
import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.entity.ActivitySignup;
import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.service.ActivityService;
import com.example.jiaoji_app_back.service.SignUpService;
import com.example.jiaoji_app_back.service.UserService;
import com.example.jiaoji_app_back.utils.msgutils.Message;
import com.example.jiaoji_app_back.utils.msgutils.Msg;
import com.example.jiaoji_app_back.utils.msgutils.MsgCode;
import com.example.jiaoji_app_back.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;
    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;
    @PostMapping("/signup")
    public Message signup(@RequestBody Map<String,Object> params){
        Integer userId = Integer.valueOf(params.get("userId").toString());
        Integer actId = Integer.valueOf(params.get("actId").toString());
        String coll = null;
        Integer grade = null;
        String club = null;
        User user = userService.getUserByUserId(userId);
        ActivityDetails activity = activityService.getActivityById(actId.longValue());
        if(user!=null){
            coll = user.getCollege();
            grade = user.getGrade();
            club = user.getClub();

        }
        if(activity.getCollege() !=null){
            if(!Objects.equals(coll, activity.getCollege())){
                return new Message("学院不符合要求",false,null);
            }
        }
        if(activity.getClub() !=null){
            if(!Objects.equals(club, activity.getClub())){
                return new Message("社团不符合要求",false,null);
            }
        }
        if(activity.getGrade() !=-1){
            if(!Objects.equals(grade, activity.getGrade())){
                return new Message("年级不符合要求",false,null);
            }
        }


        if(signUpService.SignUp(userId,actId)){
            return new Message("报名成功",true,null);
        }else{
            return new Message("请勿重复报名",false,null);
        }
    }
    @PostMapping("/getSignedUser")
    public Message getSignedUser(@RequestBody Map<String,Object> body){
        Integer actId = Integer.valueOf(body.get("actId").toString());
        System.out.println(actId);
        List<ActivitySignup> userList = signUpService.getSignedUser(actId);
        List<User> users = new ArrayList<>();

        if(userList!=null){
            //遍历
            for (ActivitySignup activitySignup : userList) {
                // 对每个ActivitySignup对象执行操作
                users.add(userService.getUserByUserId(activitySignup.getUserId()));
            }
        }
        System.out.println(users);
        return new Message("获取报名学生信息成功",true,users);
    }
}