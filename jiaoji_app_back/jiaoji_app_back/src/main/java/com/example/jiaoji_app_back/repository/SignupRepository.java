package com.example.jiaoji_app_back.repository;

import com.example.jiaoji_app_back.entity.ActivitySignup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignupRepository extends JpaRepository<ActivitySignup,Integer> {
    boolean existsActivitySignupByUserIdAndActId(Integer userID, Integer actID);
//    Object save(ActivitySignup activitySignup); //不用写，继承了JpaRepository就有了

    List<ActivitySignup> findActivityByUserId(Integer userId);

    List<ActivitySignup> findAllByPostedIs(Integer posted);

    ActivitySignup findByActIdAndUserId(Integer actId, Integer userId);
    @Query("SELECT a FROM ActivitySignup a WHERE a.actId = :actId")
    List<ActivitySignup> getSignedUser(@Param("actId") Integer actId);

}
