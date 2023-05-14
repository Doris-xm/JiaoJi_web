import React from "react";
import { Table, Space, List } from "antd";
import { Link } from "react-router-dom";
import activities from "../../Component/Activities";
import AdminActivity from "../../Component/Admin/AdminActivity";

/**
 * 管理活动页面
 * 管理员可以在此页面查看所有活动
 * 被AdminHomeView.js调用
 * edit by yhx 0513
 */

/**TODO：
 *  从数据库中按照状态获取活动信息
 */

const data = [
    {
        id: 1,
        name: '活动1',
        organizer: '组织者1',
        location: '地点1',
        activityTime: '2021-01-01',
        status: '待审核',
        feedback: '无',
    },
    {
        id: 2,
        name: '活动2',
        organizer: '组织者2',
        location: '地点2',
        activityTime: '2021-01-02',
        status: '待审核',
        feedback: '无',
    },
    {
        id: 3,
        name: '活动3',
        organizer: '组织者3',
        location: '地点3',
        activityTime: '2021-01-03',
        status: '待审核',
        feedback: '无',
    },
    {
        id: 4,
        name: '活动4',
        organizer: '组织者4',
        location: '地点4',
        activityTime: '2021-01-04',
        status: '已通过',
        feedback: '无',
    },
    {
        id: 5,
        name: '活动5',
        organizer: '组织者5',
        location: '地点5',
        activityTime: '2021-01-05',
        status: '已通过',
        feedback: '无',
    },
];

const pendingActivities = data.filter((activity) => activity.status === '待审核');
const passedActivities = data.filter((activity) => activity.status === '已通过');

const ManageView = () => {
    return (
        <div>
            <List
                grid={{ gutter: 16, column: 1 }}
                dataSource={pendingActivities}
                renderItem={(pendingActivities) => (
                    <List.Item>
                        <AdminActivity activity={pendingActivities} />
                    </List.Item>
                )}
            />
            {/* <List
                grid={{ gutter: 16, column: 1 }}
                dataSource={passedActivities}
                renderItem={(activity) => (
                    <List.Item>
                        <AdminActivity activity={activity} />
                    </List.Item>
                )}
            /> */}
        </div>
    );
}

export default ManageView;

