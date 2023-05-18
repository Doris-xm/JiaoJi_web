package com.example.jiaoji_app_back.dao;

import com.example.jiaoji_app_back.entity.ActivitySignup;

import java.util.List;

public interface SignupDao {
    boolean SignUp(Integer userID, Integer actId);
    List<ActivitySignup> getPostedSignUpList();
    boolean postMoment(Integer userID, Integer actId,Integer comment,  String content, String imgPath,String time);
}
