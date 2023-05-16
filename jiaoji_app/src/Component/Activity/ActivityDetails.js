import React, {useEffect, useState} from "react";
import { Card as AntCard } from "antd";
import "../../css/ActivityDetail.css";
import {useNavigate, useParams} from "react-router-dom";
import {getActivityByID} from "../../Services/ActivitySevice";

const ActivityDetails = () => {
    const {activityId} = useParams();
    // const activityId = 1;
    const navigate = useNavigate();// 获取navigate对象
    const [activity, setActivity] = useState(null);
    useEffect(() => {
        const fetchData = async () => {
            console.log("activityId",activityId)
            const fetchedActivity = await getActivityByID(activityId);
            setActivity(fetchedActivity);
        };
        fetchData();
    }, [activityId]);


    if(!activity) {
        return <div>加载中...</div>;
    }
    console.log("activity",activity);
    const handleGoBack = () => {
        navigate(-1); // 调用navigate返回上一页
    };
    return (
        <div className="card-container">
            <AntCard className="activity-card ant-card-hoverable">
                <div className="ant-card-head">
                    <h2 className="ant-card-head-title">{activity.name}</h2>
                </div>
                <div className="ant-card-body">
                    <p>{activity.content}</p>
                    <ul>
                        <li>地点：{activity.location}</li>
                        <li>报名时间：{activity.signupTime}</li>
                        <li>活动时间：{activity.activityTime}</li>
                        <li>开设学院：{activity.departments}</li>
                        <li>报名限制：{activity.signupRestriction}</li>
                        <li>招募人数：{activity.recruitmentNumber}</li>
                        <li>主办单位：{activity.organizer}</li>
                        <li>素拓奖励：{activity.suScore} 分</li>
                        <li>劳动教育学时：{activity.laborHour} 时</li>
                    </ul>
                </div>
            </AntCard>
        </div>
    );
};

export default ActivityDetails;
