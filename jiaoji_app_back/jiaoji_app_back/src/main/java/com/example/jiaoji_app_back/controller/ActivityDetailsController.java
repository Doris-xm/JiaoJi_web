/*author: qyl*/
package com.example.jiaoji_app_back.controller;

import com.example.jiaoji_app_back.constant.Constant;
import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.entity.ActivityResponse;
import com.example.jiaoji_app_back.utils.msgutils.Message;
import com.example.jiaoji_app_back.repository.ActivityDetailsRepository;
import com.example.jiaoji_app_back.service.ActivityService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ActivityDetailsController {
    @Autowired
    private ActivityService activityService;
    private final ActivityDetailsRepository activityDetailsRepository;

    public ActivityDetailsController(ActivityDetailsRepository activityDetailsRepository) {
        this.activityDetailsRepository = activityDetailsRepository;
    }

    @RequestMapping("/activity")
    public ActivityDetails getActivityById(@RequestParam("id") Long id) {
        return  activityService.getActivityById(id);
    }
    @RequestMapping("/allactivities")
    public List<ActivityDetails> getList(){
        return activityService.getActivityList();
    }

    @RequestMapping("/activities")
    public List<ActivityDetails> getPassedActivities(){
        return activityService.getActivityList();
    }

    @RequestMapping("/my_activities")
    public List<ActivityResponse> getMyActivities(@RequestParam("userId") int userId) {
        return activityService.getMyActivityList(userId);
    }
    @RequestMapping("/search")
    public List<ActivityDetails> searchActivity(@RequestParam("keyword") String keyword){
        return activityService.searchActivity(keyword);
    }

    @GetMapping("/activities")
    public List<ActivityDetails> getPassedList(){
        return activityService.getPassedActivity();
    }

    @PostMapping("/changeStatus")
    public Message changeStatus(@RequestBody Map<String,Object> body){
        Long id = Long.valueOf(body.get("id").toString());
        Integer status = Integer.valueOf(body.get("status").toString());
        String comments = (String) body.get("comments");
        return activityService.changeStatus(id, status,comments);
    }

    @PostMapping("/release")
    public Message release(@RequestBody Map<String,Object> body){
        long userId = Long.parseLong(body.get("userId").toString());
        String name = (String) body.get("name");
        String content = (String) body.get("content");
        String location = (String) body.get("location");
        String signupTime = (String) body.get("signupTime");
        String activityTime = (String) body.get("activityTime");
        String departments = (String) body.get("departments");
        String signupRestriction = (String) body.get("signupRestriction");
        String college = (String) body.get("college");
        String grade = (String) body.get("grade");
        String club = (String) body.get("club");
        Long recruitmentNumber = Long.valueOf(body.get("recruitmentNumber").toString());
        Long remainingNumber = recruitmentNumber;
        String organizer = (String) body.get("organizer");
        Long suScore = Long.valueOf(body.get("suScore").toString());
        Long laborHour = Long.valueOf(body.get("laborHour").toString());
        Integer status = ActivityDetails.Status.TODO.ordinal();
        String comments = null;
        String photo = "https://th.bing.com/th/id/R.785580b0aa9cce1c7e016db5ee2e078e?rik=ebpuQj03uKxGQg&riu=http%3a%2f%2fphotos.tuchong.com%2f255820%2ff%2f2852945.jpg&ehk=8sZ0LLnnaIXhdwT1M5Zk2xrfIMFcE%2bV45Nc1839Gj7Y%3d&risl=&pid=ImgRaw&r=0";

        //获取activity_details表行数


        Message message = activityService.release(name,content,location,signupTime,activityTime,departments,signupRestriction,college,grade,club,recruitmentNumber,remainingNumber,organizer,suScore,laborHour,status,comments,photo);
        Long rowCount = activityService.getActivityCount();
        activityService.addReleaseRecord(Math.toIntExact(userId), Math.toIntExact(rowCount));
        return message;
    }
        @RequestMapping("/my_release_activities")
        public Message findMyRelease(@RequestParam("userId") Integer userId){
    //        return new Message("ok",true,null);
            return activityService.findMyRelease(userId);
        }


//    @PostMapping("/handleSignup")
//    public Message handleSignup(@RequestBody Map<String,Object> body){
//        Long userId = Long.valueOf(body.get("userId").toString());
//        String college = (String) body.get("college");
//        String grade = (String) body.get("grade");
//        String club = (String) body.get("club");
//        Long activityId = Long.valueOf(body.get("activityId").toString());
//        ActivityDetails activityDetails = activityService.getPassedActivitiesByAId(activityId);
//        //剩余名额减一
//        if(activityDetails.getRemainingNumber()>0){
//
//            if(activityDetails.getCollege() !=null){
//                if(!Objects.equals(college, activityDetails.getCollege())){
//                    return new Message("学院不符合要求",false,null);
//                }
//            }
//            if(activityDetails.getClub() !=null){
//                if(!Objects.equals(club, activityDetails.getClub())){
//                    return new Message("社团不符合要求",false,null);
//                }
//            }
//            if(activityDetails.getGrade() !=null){
//                if(!Objects.equals(grade, activityDetails.getGrade())){
//                    return new Message("年级不符合要求",false,null);
//                }
//            }
//            activityDetails.setRemainingNumber(activityDetails.getRemainingNumber()-1);
//            Message message = activityService.updateActivityRemainingNumber(activityId,activityDetails.getRemainingNumber() -1);
//            System.out.println(message.getOk());
//            return new Message("报名成功",true,activityDetails);
//        }else
//            return new Message("报名失败",false,null);
//
//    }



}

