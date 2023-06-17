package com.example.jiaoji_app_back.controller;


// 导入所需的类
import com.example.jiaoji_app_back.constant.Constant;
import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.entity.UserAuth;
import com.example.jiaoji_app_back.service.UserService;
import com.example.jiaoji_app_back.utils.msgutils.Msg;
import com.example.jiaoji_app_back.utils.msgutils.MsgCode;
import com.example.jiaoji_app_back.utils.msgutils.MsgUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@RestController
public class JaccountController {
    @Autowired
    private UserService userService;
    @PostMapping("/jaccountProfile")
    public ResponseEntity<String> getToken(@RequestBody MultiValueMap<String, String> requestBody) {
        String url = "http://jaccount.sjtu.edu.cn/oauth2/token";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class); // 拿回响应数据

        if (response.getStatusCode() == HttpStatus.OK) {
            String responseBody = response.getBody();
            // 处理响应数据...
            return ResponseEntity.ok(responseBody);
        } else {
            // 处理错误...
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }



    @PostMapping("/profile")
    public Msg getProfile(@RequestBody Map<String, Object> requestBody) {
        String url = "https://api.sjtu.edu.cn/v1/me/profile";
        String accessToken = (String) requestBody.get("AccessToken");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);

        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(url));

        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            JSONObject jsonObject = JSONObject.fromObject(responseEntity.getBody());
            System.out.println("jsonObject" + jsonObject);
            JSONArray entities = jsonObject.getJSONArray("entities");
            JSONObject entity = entities.getJSONObject(0);
            System.out.println(entity);
            String username = entity.getString("account");
            User user = userService.getUserByUserName(username);
            if(user != null){
                UserAuth auth = userService.getUserAuthByUserId(user.getUserId());
                JSONObject obj = new JSONObject();
                obj.put(Constant.USER_ID, auth.getUserId());
                obj.put(Constant.USERNAME, auth.getUsername());
                obj.put(Constant.USER_TYPE, auth.getUserType());
                obj.put(Constant.AVATAR, user.getAvatar());
                obj.put(Constant.NICKNAME, user.getNickname());
                obj.put(Constant.GENDER, user.getGender());
                obj.put(Constant.EMAIL, user.getMail());
                obj.put(Constant.PHONE, user.getTel());
                obj.put(Constant.COLLEGE, user.getCollege());
                obj.put(Constant.STU_ID, user.getStudentId());
                obj.put(Constant.CLUB, user.getClub());
                obj.put(Constant.GRADE, user.getGrade());

                JSONObject data = JSONObject.fromObject(obj);

                return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
            }
            /*Jaccount 第一次登录自动注册，初始密码=用户名*/
            String nickname = entity.getString("name");
            String email = entity.getString("email");
            String phone = entity.getString("mobile");
            String password = username;
            int gender = entity.getString("gender").equals("female") ? 0 : 1;
            String college =  JSONObject.fromObject(entity.getString("organize")).getString("name");
            String studentId = entity.getString("code");
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setNickname(nickname);
            newUser.setMail(email);
            newUser.setTel(phone);
            newUser.setGender(gender);
            newUser.setCollege(college);
            newUser.setStudentId(studentId);
            newUser.setAvatar("https://th.bing.com/th/id/R.c54d22a232d76f70fa39884a77c55da1?rik=ziHhbN%2fIIKNAAA&pid=ImgRaw&r=0");
            userService.createNewUser(newUser);
            UserAuth newAuth = new UserAuth();
            newAuth.setUsername(username);
            newAuth.setPassword(password);
            newAuth.setUserType(0);
            newAuth.setUserId(newUser.getUserId());
            userService.createNewUserAuth(newAuth);
            JSONObject obj = new JSONObject();
            obj.put(Constant.USER_ID, newAuth.getUserId());
            obj.put(Constant.USERNAME, newAuth.getUsername());
            obj.put(Constant.USER_TYPE, newAuth.getUserType());
            obj.put(Constant.AVATAR, newUser.getAvatar());
            obj.put(Constant.NICKNAME, newUser.getNickname());
            obj.put(Constant.GENDER, newUser.getGender());
            obj.put(Constant.EMAIL, newUser.getMail());
            obj.put(Constant.PHONE, newUser.getTel());
            obj.put(Constant.COLLEGE, newUser.getCollege());
            obj.put(Constant.STU_ID, newUser.getStudentId());
            obj.put(Constant.CLUB, newUser.getClub());
            obj.put(Constant.GRADE, newUser.getGrade());
            JSONObject data = JSONObject.fromObject(obj);
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
        } else {
            return MsgUtil.makeMsg(MsgCode.ERROR, "Error occurred while retrieving profile.", null);
        }
    }


}
