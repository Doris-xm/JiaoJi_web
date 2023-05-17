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
        System.out.println(ActivityDetails.Status.OVER.ordinal());
//      return activityDetailsRepository.findAllByStatusGreaterThanEqualAndStatusLessThan(ActivityDetails.Status.PASS.ordinal(), ActivityDetails.Status.OVER.ordinal());
        return activityDetailsRepository.findAll();
    }
    @Override
    public List<ActivityResponse> getMyActivities(int userId) {
        List<ActivitySignup> activitySignups = signupRepository.findActivityByUserId(userId);
        List<ActivityResponse> activityResponses = new ArrayList<>();

        for (ActivitySignup activitySignup : activitySignups) {
            long activityId = (long)activitySignup.getActId();
            ActivityDetails activityDetails = activityDetailsRepository.findById(activityId);
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
        return activityDetailsRepository.findAllByStatusGreaterThanEqualAndStatusLessThan(ActivityDetails.Status.PASS.ordinal(), ActivityDetails.Status.OVER.ordinal());
    }
    @Override
    public  ActivityDetails changeStatus(Long id, Integer status, String comments){
        ActivityDetails activityDetails = activityDetailsRepository.findById(id);
        System.out.println("before" + activityDetails);
        activityDetails.setStatus(status);
        activityDetails.setComments(comments);
        System.out.println("after" + activityDetails);
        activityDetailsRepository.save(activityDetails);
        return activityDetails;
    }


    @Override
    public  void updateActivityRemainingNumber(Long activityId,Long remainingNumber){
        ActivityDetails activityDetails = activityDetailsRepository.findById(activityId);
        activityDetails.setRemainingNumber(remainingNumber);
        activityDetailsRepository.save(activityDetails);
    }

    @Override
    public ActivityDetails getActivityById(Long activityId){
        return activityDetailsRepository.findById(activityId);
    }

    @Override
    public List<ActivityDetails> searchActivity(String keyword) {
        System.out.println(keyword);
//        return activityDetailsRepository.findAllByNameContainingAndStatusGreaterThan(keyword,ActivityDetails.Status.TODO.ordinal());
        return activityDetailsRepository.findAllByNameContainingOrContentContainingOrCollegeContainingOrClubContainingAndStatusGreaterThan(keyword,keyword,keyword,keyword,ActivityDetails.Status.TODO.ordinal());
    }

}