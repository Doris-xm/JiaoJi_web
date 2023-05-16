package com.example.jiaoji_app_back.daoimpl;

import com.example.jiaoji_app_back.dao.ActivityDao;
import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.entity.ActivityResponse;
import com.example.jiaoji_app_back.entity.ActivitySignup;
import com.example.jiaoji_app_back.repository.ActivityDetailsRepository;
import com.example.jiaoji_app_back.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActivityDaoImpl implements ActivityDao {
    @Autowired
    private ActivityDetailsRepository activityDetailsRepository;
    @Autowired
    private SignupRepository signupRepository;
    @Override
    public List<ActivityDetails> getAllActivities() {
        return activityDetailsRepository.findAllActivity();
    }
    @Override
    public List<ActivityResponse> getMyActivities(int userId) {
        List<ActivitySignup> activitySignups = signupRepository.findActivityByUserId(userId);
        List<ActivityResponse> activityResponses = new ArrayList<>();

        for (ActivitySignup activitySignup : activitySignups) {
            long activityId = (long)activitySignup.getActId();
            ActivityDetails activityDetails = activityDetailsRepository.getActivityById(activityId);
            activityResponses.add(new ActivityResponse(activitySignup.getUserId(),
                    activitySignup.getActId(),
                    activitySignup.getState(),
                    activitySignup.getComment(),
                    activitySignup.getCommentDetail(),
                    activityDetails.getName(),
                    activityDetails.getActivityTime(),
                    activityDetails.getPhoto()));

        }
        return activityResponses;
    }

    @Override
    public  List<ActivityDetails> getPassedActivity(){
        return activityDetailsRepository.findPassedActivity();
    }
    @Override
    public  ActivityDetails changeStatus(Long id, String status, String comments){
        return activityDetailsRepository.changeStatus(id,status,comments);
    }
    @Override
    public  ActivityDetails handleSignup(Long userId, Long activityId){
        return activityDetailsRepository.handleSignup(userId,activityId);
    }
    @Override
    public ActivityDetails getPassedActivityByAId(Long activityId){
        return activityDetailsRepository.getPassedActivityById(activityId);
    }
    @Override
    public  void updateActivityRemainingNumber(Long activityId,Long remainingNumber){
        activityDetailsRepository.updateActivityRemainingNumber(activityId,remainingNumber);
    }

    @Override
    public ActivityDetails getActivityById(Long activityId){
        return activityDetailsRepository.getActivityById(activityId);
    }

}