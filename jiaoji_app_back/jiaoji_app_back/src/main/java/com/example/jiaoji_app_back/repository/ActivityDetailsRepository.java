//package com.example.jiaoji_app_back.repository;
//
//import com.example.jiaoji_app_back.entity.ActivityDetails;
//
//import java.util.List;
//
//public interface ActivityDetailsRepository {
//
//    List<ActivityDetails> findAllActivity();
//    List<ActivityDetails> findPassedActivity();
//
//    ActivityDetails changeStatus(Long id, String status, String comments);
//
//    ActivityDetails handleSignup(Long userId, Long activityId);
//
//    ActivityDetails getPassedActivityById(Long activityId);
//    ActivityDetails getActivityById(Long activityId);
//
//    void updateActivityRemainingNumber(Long activityId,Long remainingNumber);
//}

package com.example.jiaoji_app_back.repository;

import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.entity.ActivitySignup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityDetailsRepository extends JpaRepository<ActivityDetails,Integer> {
    ActivityDetails findById(Long activityId);
    List<ActivityDetails> findAll();

    List<ActivityDetails> findAllByStatusGreaterThanEqualAndStatusLessThan(Integer startStatus, Integer endStatus);
    List<ActivityDetails> findByStatus(ActivityDetails.Status Status);
    List<ActivityDetails> findAllByNameContainingOrContentContainingOrCollegeContainingOrClubContainingAndStatusGreaterThan(String keyword1,String keyword2,String keyword3,String keyword4,Integer status);

    long count();
//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO activity_details (name, content, location, signupTime, activityTime, departments, signupRestriction, college, grade, club, recruitmentNumber, remainingNumber, organizer, suScore, laborHour, status, comments,photo) " +
//            "VALUES ( :name, :content, :location, :signupTime, :activityTime, :departments, :signupRestriction, :college, :grade, :club, :recruitmentNumber, :remainingNumber, :organizer, :suScore, :laborHour, :status, :comments,:photo)",
//            nativeQuery = true)
//    void insertRecord( @Param("name") String name, @Param("content") String content,
//                       @Param("location") String location, @Param("signupTime") String signupTime,
//                       @Param("activityTime") String activityTime, @Param("departments") String departments,
//                       @Param("signupRestriction") String signupRestriction, @Param("college") String college,
//                       @Param("grade") String grade, @Param("club") String club,
//                       @Param("recruitmentNumber") Integer recruitmentNumber, @Param("remainingNumber") Integer remainingNumber,
//                       @Param("organizer") String organizer, @Param("suScore") Integer suScore,
//                       @Param("laborHour") Integer laborHour, @Param("status") Integer status,
//                       @Param("comments") String comments,@Param("photo")String photo);
//

//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO activity_release (user_id,act_id) " +
//            "VALUES ( :user_id, :act_id)",
//            nativeQuery = true)
//    void addReleaseRecord(@Param("user_id")Integer userId,@Param("act_id") Integer num);


//    @Transactional
//    @Query(value = "SELECT COUNT(*) FROM activity_details", nativeQuery = true)
//    Long getActivityCount();



}
