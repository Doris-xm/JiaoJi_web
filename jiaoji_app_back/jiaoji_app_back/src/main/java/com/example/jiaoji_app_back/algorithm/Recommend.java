package com.example.jiaoji_app_back.algorithm;


import com.example.jiaoji_app_back.entity.ActivityResponse;
import com.example.jiaoji_app_back.entity.ActivitySignup;
import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.service.ActivityService;
import com.example.jiaoji_app_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.jiaoji_app_back.constant.ActivityClass;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@RestController
public class Recommend {
    /**
     * 在给定user_id的情况下，计算其他用户和它的距离并排序
     * @param userId
     * @return
     */
    @Autowired
    private ActivityService activityService;
    @Autowired
    private UserService userService;
    private Map<Double, Integer> computeNearestNeighbor(int userId, List<User> users) {
        Map<Double, Integer> distances = new TreeMap<>();

        User u1 = new User();
        for (User user:users) {
            if (userId == user.getUserId()) {
                u1 = user;
            }
        }

        for (int i = 0; i < users.size(); i++) {
            User u2 = users.get(i);

            if (userId != u2.getUserId() && ! userService.isAdmin(u2.getUserId())) {
                double distance = pearson_dis(u2.getUserId(), u1.getUserId());
                distances.put(distance, u2.getUserId());
            }
        }
        System.out.println("该用户与其他用户的皮尔森相关系数 -> " + distances);
        return distances;
    }

    public List<Integer> parseEigenvector(Integer userId) {
        List<Integer> eigenVector = new ArrayList<>();
        List<ActivityResponse> activityResponses = activityService.getMyActivityList(userId);
        // 初始化特征向量为0
        for (int i = 0; i < ActivityClass.NUM_OF_CLASS; i++) {
            eigenVector.add(0);
        }

        for(ActivityResponse activityResponse:activityResponses){
            ActivityDetails activityDetails = activityResponse.getActivityDetails();
            String typeString = activityDetails.getType();
            if(typeString == null) continue;
            String[] typeArray = typeString.split(",");
            for (String type : typeArray) {
                int index = Integer.parseInt(type.trim()); //活动类型

                int count = eigenVector.get(index);
                eigenVector.set(index, count + 1);
            }
        }

        return eigenVector;
    }



    /**
     * 计算2个用户报名活动类型之间的pearson距离
     * 选择公式四进行计算
     * @param userId1
     * @param userId2
     * @return
     */
    private double pearson_dis(int userId1, int userId2) {
        List<Integer> eigenVector1 = parseEigenvector(userId1);
        List<Integer> eigenVector2 = parseEigenvector(userId2);

        int n = ActivityClass.NUM_OF_CLASS;
        double Ex = eigenVector1.stream().mapToDouble(x -> x).sum();
        double Ey = eigenVector2.stream().mapToDouble(y -> y).sum();
        double Ex2 = eigenVector1.stream().mapToDouble(x -> Math.pow(x, 2)).sum();
        double Ey2 = eigenVector2.stream().mapToDouble(y -> Math.pow(y, 2)).sum();
        double Exy = IntStream.range(0, n).mapToDouble(i -> eigenVector1.get(i) * eigenVector2.get(i)).sum();
        double numerator = Exy - Ex * Ey / n;
        double denominator = Math.sqrt((Ex2 - Math.pow(Ex, 2) / n) * (Ey2 - Math.pow(Ey, 2) / n));

        if (denominator == 0) {
            return 0.0;
        }

        return numerator / denominator;
    }


    public List<ActivityResponse> recommend(Integer userId) {
        //找到最近邻
        List<User> users = userService.getAllUsers();
        Map<Double, Integer> distances = computeNearestNeighbor(userId, users);
        Integer nearest = distances.values().iterator().next();
        System.out.println("最近邻 -> " + nearest);

        // 找到最近邻参加过但用户未参加的活动，进行推荐
//        User neighborRatings = null;
//        for (User user : users) {
//            if (nearest.equals(user.getUserId())) {
//                neighborRatings = user;
//                break;
//            }
//        }
        List<ActivityResponse> neighborActivityList = activityService.getMyActivityList(nearest);
        System.out.println("最近邻参加过的活动 -> " + neighborActivityList);

//        User userRatings = null;
//        for (User user : users) {
//            if (userId.equals(user.getUserId())) {
//                userRatings = user;
//                break;
//            }
//        }
        List<ActivityResponse> userActivityList = activityService.getMyActivityList(userId);
        System.out.println("用户参加过的活动 -> " + userActivityList);

        // 根据自己和邻居的活动计算推荐的活动
        List<ActivityResponse> recommendedActivities = new ArrayList<>();
        for (ActivityResponse activityResponse : neighborActivityList) {
            if (!userActivityList.contains(activityResponse)) {
                recommendedActivities.add(activityResponse);
            }
        }
        return recommendedActivities;
    }
}

