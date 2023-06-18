package com.example.jiaoji_app_back.algorithm;

import com.example.jiaoji_app_back.constant.Constant;
import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.service.UserService;
import io.swagger.models.auth.In;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RadarChartGenerator {
    @Autowired
    private Recommend recommend_algorithm;
    @Autowired
    private UserService userService;
    @PostMapping("/getRadarChart")
    public  String generateRadarChart(@RequestParam(Constant.USER_ID) int userId) {
        // 创建JSON对象
        List<Integer> eigenVector = recommend_algorithm.parseEigenvector(userId);
        JSONObject chartData = new JSONObject();

        // 创建标签数组
        JSONArray labels = new JSONArray();
        for (int i = 0; i < eigenVector.size(); i++) {
            labels.put("Label " + i);
        }
        chartData.put("labels", labels);

        // 创建数据集
        JSONArray datasets = new JSONArray();
        JSONObject dataset = new JSONObject();
        dataset.put("label", "User EigenVector");

        // 创建数据数组
        JSONArray data = new JSONArray();
        for (int value : eigenVector) {
            data.put(value);
        }
        dataset.put("data", data);

        // 将数据集添加到数据集数组中
        datasets.put(dataset);

        // 添加数据集数组到JSON对象中
        chartData.put("datasets", datasets);

        // 生成JSON字符串
        String jsonString = chartData.toString();

        // 返回JSON字符串
        return jsonString;
    }

    @PostMapping("/getMatrix")
    public  String generateMatrix() {
        // 创建JSON对象
        List<User> users=userService.getAllUsers();
        List<Integer> eigenVector = recommend_algorithm.parseEigenvector(userId);
        JSONObject chartData = new JSONObject();

        // 创建标签数组
        JSONArray labels = new JSONArray();
        for (int i = 0; i < eigenVector.size(); i++) {
            labels.put("Label " + i);
        }
        chartData.put("labels", labels);

        // 创建数据集
        JSONArray datasets = new JSONArray();
        JSONObject dataset = new JSONObject();
        dataset.put("label", "User EigenVector");

        // 创建数据数组
        JSONArray data = new JSONArray();
        for (int value : eigenVector) {
            data.put(value);
        }
        dataset.put("data", data);

        // 将数据集添加到数据集数组中
        datasets.put(dataset);

        // 添加数据集数组到JSON对象中
        chartData.put("datasets", datasets);

        // 生成JSON字符串
        String jsonString = chartData.toString();

        // 返回JSON字符串
        return jsonString;
    }
}
