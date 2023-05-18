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

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/uploadphoto")
    @ResponseStatus(HttpStatus.OK)
    public String post(@RequestBody List<File> fileList) {
        // 处理上传的文件
        System.out.println(fileList);
        for (File file : fileList) {
            System.out.println(file);
        }
        return "success";
    }


    @RequestMapping("/poster")
    public List<ActivitySignup> getPoster() {
        return signUpService.getPostedSignUpList();
    }

}

