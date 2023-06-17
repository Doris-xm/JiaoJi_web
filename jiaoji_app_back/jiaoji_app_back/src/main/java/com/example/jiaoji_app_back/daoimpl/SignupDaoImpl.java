package com.example.jiaoji_app_back.daoimpl;

import com.example.jiaoji_app_back.dao.SignupDao;
import com.example.jiaoji_app_back.entity.ActivitySignup;
import com.example.jiaoji_app_back.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SignupDaoImpl implements SignupDao {
    @Autowired
    private SignupRepository signupRepository;
    @Override
    public boolean SignUp(Integer userId, Integer actId) {
        if(signupRepository.existsActivitySignupByUserIdAndActId(userId,actId)){
            return false;
        }
        signupRepository.save(new ActivitySignup(userId,actId));
        return true;
    }
    @Override
    public List<ActivitySignup> getPostedSignUpList(){
        return signupRepository.findAllByPostedIs(1);
    }

    @Override
    public boolean postMoment(Integer userID, Integer actId, Integer comment, String content, String imgPath,String time){
        ActivitySignup activitySignup = signupRepository.findByActIdAndUserId(actId,userID);
        activitySignup.setPosted(1);
        activitySignup.setComment(comment);
        activitySignup.setCommentDetail(content);
        activitySignup.setCommentPhoto(imgPath);
//        activitySignup.postMoment(userID,actId,comment,content,imgPath,time);
        signupRepository.save(activitySignup);
        return true;
    }
    @Override
    public List<ActivitySignup> getSignedUser(Integer actId){
        return signupRepository.getSignedUser(actId);
    }
}
