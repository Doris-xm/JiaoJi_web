package com.example.jiaoji_app_back.controller;

import com.example.jiaoji_app_back.constant.Constant;
import com.example.jiaoji_app_back.entity.UserAuth;
import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.service.UserService;
import com.example.jiaoji_app_back.utils.msgutils.Msg;
import com.example.jiaoji_app_back.utils.msgutils.MsgCode;
import com.example.jiaoji_app_back.utils.msgutils.MsgUtil;
import com.example.jiaoji_app_back.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LoginControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private LoginController loginController;

    @Test
    void testLogin() {
        // 模拟 UserService.checkUser() 方法的行为
        UserAuth auth = new UserAuth();
        auth.setUserId(1);
        auth.setUsername("root");
        auth.setPassword("root");
        auth.setUserType(1);

        User user = new User();
        user.setAvatar("https://www.lizhi.io/wp-content/uploads/2020/03/datagrip.png");
        user.setNickname("秋田");
        user.setUserId(1);
        user.setGender(0);
        user.setTel("13178914567");
        user.setCollege("电子信息与电气工程学院");
        user.setMail("qiutian@sjtu.edu.cn");
        user.setGrade(2);

        // 其他属性设置...

        // 使用 Mockito 模拟 UserService.checkUser() 方法的返回结果
        when(userService.checkUser("root", "root")).thenReturn(auth);
        when(userService.getUserByUserId(auth.getUserId())).thenReturn(user);

        // 构造请求参数
        Map<String, String> params = new HashMap<>();
        params.put(Constant.USERNAME, "root");
        params.put(Constant.PASSWORD, "root");

        // 调用登录接口
        Msg result = loginController.login(params);

        // 验证返回结果是否符合预期
        assertEquals(MsgCode.SUCCESS.getStatus(), result.getStatus());
        assertEquals(MsgUtil.LOGIN_SUCCESS_MSG, result.getMsg());

        // 验证返回的数据中是否包含正确的用户信息
        JSONObject data = (JSONObject) result.getData();
        assertEquals(auth.getUserId(), data.getInt(Constant.USER_ID));
        assertEquals(auth.getUsername(), data.getString(Constant.USERNAME));
        assertEquals(auth.getUserType(), data.getInt(Constant.USER_TYPE));
        assertEquals(user.getAvatar(), data.getString(Constant.AVATAR));
        assertEquals(user.getNickname(), data.getString(Constant.NICKNAME));
        // 验证其他属性...

        // 可以继续添加其他的断言和验证逻辑
    }
    //TODO: 测试登录失败的情况
    //TODO: 测试Controller其他函数
    @Test
    void testLogout() {
        // 模拟 UserService.checkUser() 方法的行为
        Msg result = loginController.logout();
        assertEquals(MsgCode.SUCCESS.getStatus(), result.getStatus());
        assertEquals(MsgUtil.LOGOUT_SUCCESS_MSG, result.getMsg());
    }
    @Test
    void testCheckSession() {
        // 模拟 UserService.checkUser() 方法的行为
        JSONObject auth = SessionUtil.getAuth();
        Msg result = loginController.checkSession();
        if(auth == null){
            assertEquals(result.getStatus(), MsgCode.NOT_LOGGED_IN_ERROR.getStatus());
            assertEquals(result.getMsg(), MsgUtil.NOT_LOGGED_IN_ERROR_MSG);
        }
        else{
            assertEquals(result.getStatus(), MsgCode.SUCCESS.getStatus());
            assertEquals(result.getMsg(), MsgUtil.SUCCESS_MSG);
        }
    }



}
