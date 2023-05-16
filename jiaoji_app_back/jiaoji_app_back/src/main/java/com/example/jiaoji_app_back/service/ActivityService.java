package com.example.jiaoji_app_back.service;

import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.utils.msgutils.Message;

import java.util.List;

public interface ActivityService {
    List<ActivityDetails> getActivityList();

    Message getPassedActivity();

    Message changeStatus(Long id, String status, String comments);

    Message handleSignup(Long userId, Long activityId);

    ActivityDetails getPassedActivitiesByAId(Long activityId);
    ActivityDetails getActivityById(Long activityId);

    Message updateActivityRemainingNumber(Long l,Long remainingNumber);
}