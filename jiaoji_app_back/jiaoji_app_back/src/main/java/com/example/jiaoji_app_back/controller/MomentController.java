package com.example.jiaoji_app_back.controller;

import com.example.jiaoji_app_back.constant.Constant;
import com.example.jiaoji_app_back.entity.ActivitySignup;
import com.example.jiaoji_app_back.entity.UserAuth;
import com.example.jiaoji_app_back.service.SignUpService;
import com.example.jiaoji_app_back.utils.msgutils.Msg;
import com.example.jiaoji_app_back.utils.msgutils.MsgCode;
import com.example.jiaoji_app_back.utils.msgutils.MsgUtil;
import com.example.jiaoji_app_back.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MomentController {
    @Autowired
    SignUpService signUpService;

//    @PostMapping
//    @RequestMapping("/uploadphoto")
//    @ResponseStatus(HttpStatus.OK)
//    public String post(@RequestBody List<File> fileList) {
//        // 处理上传的文件
//        System.out.println(fileList);
//        for (File file : fileList) {
//            System.out.println(file);
//        }
//        return "success";
//    }


    @RequestMapping("/poster")
    public List<ActivitySignup> getPoster() {
        return signUpService.getPostedSignUpList();
    }

    @PostMapping
    @RequestMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public Msg login(@RequestBody Map<String, String> params){
        String userId = params.get(Constant.USER_ID);
        String actId = params.get(Constant.ACT_ID);
        String comment = params.get(Constant.COMMENT);
        String comment_detail = params.get(Constant.COMMENT_DETAIL);
        String comment_photo = params.get(Constant.COMMENT_PHOTO);
        String post_time = params.get(Constant.POST_TIME);
        System.out.println(userId);
        System.out.println(actId);
        System.out.println(comment);
        System.out.println(comment_detail);
        System.out.println(comment_photo);
        System.out.println(post_time);

        if(signUpService.postMoment(Integer.parseInt(userId),Integer.parseInt(actId),Integer.parseInt(comment),comment_detail,comment_photo,post_time)){
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.SIGNUP_SUCCESS_MSG);
        }else{
            return MsgUtil.makeMsg(MsgCode.ERROR);
        }
    }

}

