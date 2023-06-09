package com.example.jiaoji_app_back.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;

/*
* @brief: 这个类不对应表格，用来返回“我的活动”的信息
* 选取了ActivityDetails和ActivitySignUp中的部分字段
* */
@Data
public class ActivityResponse {

//    private int userId;
//    private int actId;
//    private int state;
//    private int comment;
//    private String commentDetail;
//    private String name;
//    private String activityTime;
//    private String photo;
//
//
//    public ActivityResponse(int userId, int actId, int state, int comment, String comments1, String name, String activityTime, String photo) {
//        this.userId = userId;
//        this.actId = actId;
//        this.state = state;
//        this.comment = comment;
//        this.commentDetail = comments1;
//        this.name = name;
//        this.activityTime = activityTime;
//        this.photo = photo;
//    }
    private ActivitySignup activitySignup;
    private ActivityDetails activityDetails;
    public ActivityResponse(ActivitySignup activitySignup, ActivityDetails activityDetails) {
        this.activitySignup = activitySignup;
        this.activityDetails = activityDetails;
    }

}
