import React from "react";
import { Card as AntCard } from "antd";
import "../css/ActivityDetail.css";

const ActivityDetails = ({ activity }) => {
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
