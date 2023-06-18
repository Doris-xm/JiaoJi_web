package com.example.jiaoji_app_back.service;

import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.entity.ActivityResponse;
import com.example.jiaoji_app_back.utils.msgutils.Message;

import java.util.List;

public interface ActivityService {
    public List<ActivityDetails> getActivityList();
    public List<ActivityResponse> getMyActivityList(int userId) ;
    public List<ActivityDetails> getPassedActivity();
    public Message changeStatus(Long id, Integer status, String comments);
    public Message updateActivityRemainingNumber(Long l,Long remainingNumber);

    public ActivityDetails getActivityById(Long activityId);
    public List<ActivityDetails> searchActivity(String keyword);
    public Message release(String name, String content, String location, String signupTime, String activityTime, String departments, String signupRestriction, String college, Integer grade, String club, Long recruitmentNumber, Long remainingNumber, String organizer, Long suScore, Long laborHour, Integer status, String comments, String photo, double lng, double lat);
    public void addReleaseRecord(Integer userId,Integer num);
    public Long getActivityCount();
    Message findMyRelease(Integer userId);
}