package com.example.jiaoji_app_back.dao;

import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.entity.ActivityResponse;
import com.example.jiaoji_app_back.entity.ActivityRelease;
import com.example.jiaoji_app_back.entity.ActivitySignup;

import java.util.ArrayList;
import java.util.List;

public interface ActivityDao {

     List<ActivityDetails> getAllActivities();

     List<ActivityResponse> getMyActivities(int userId) ;

     List<ActivityDetails> getPassedActivity();

      ActivityDetails changeStatus(Long id, Integer status, String comments);

      void updateActivityRemainingNumber(Long activityId,Long remainingNumber);

     ActivityDetails getActivityById(Long activityId);

     List<ActivityDetails> searchActivity(String keyword);
    void release(String name, String content, String location, String signupTime, String activityTime, String departments, String signupRestriction, String college, String grade, String club, Long recruitmentNumber, Long remainingNumber, String organizer, Long suScore, Long laborHour, Integer status, String comments,String photo);

    void addReleaseRecord(Integer userId, Integer num);

    Long getActivityCount();

    List<ActivityRelease> findMyRelease(Integer userId);

}