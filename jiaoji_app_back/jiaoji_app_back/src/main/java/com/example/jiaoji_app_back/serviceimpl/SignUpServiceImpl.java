package com.example.jiaoji_app_back.serviceimpl;

import com.example.jiaoji_app_back.dao.SignupDao;
import com.example.jiaoji_app_back.entity.ActivitySignup;
import com.example.jiaoji_app_back.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpServiceImpl implements SignUpService {
        @Autowired
         private SignupDao signupDao;
        @Override
        public boolean SignUp(Integer userID, Integer actId) {
            return signupDao.SignUp(userID,actId);
        }
        @Override
       public List<ActivitySignup> getPostedSignUpList(){
            return signupDao.getPostedSignUpList();
        }
}
