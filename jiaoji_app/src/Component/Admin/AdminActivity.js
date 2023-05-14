import React from "react";
import {Card, Button, Modal, Input, Radio} from "antd";
import { useState,setState } from "react";

/**
 * 管理者单个活动视图
 * 被Manage.js调用
 * 被AdminHistoryView.js调用
 * edit by yhx 0513
 */

const ManageActivityView = ({ activity }) => {
    const [activeTabKey, setActiveTabKey] = useState('brief');
    const onTabChange = (key) => {
        setActiveTabKey(key);
    };

    const tabList = [
        {
            key: 'brief',
            tab: '活动简介',
        },
        {
            key: 'detail',
            tab: '活动详情',
        },
    ];

    const contentList = {
        brief: <div>
            活动名称：{activity.name}
            <br/>
            活动时间：{activity.activityTime}
            <br/>
            组织者：{activity.organizer}
            <br/>
        </div>,
        detail: <div>
            活动名称：{activity.name}
            <br/>
            活动时间：{activity.activityTime}
            <br/>
            组织者：{activity.organizer}
            <br/>
            活动地点：{activity.location}
            <br/>
            报名时间：{activity.signUpTime}
            <br/>
            活动内容：{activity.content}
            <br/>
        </div>,
    };

    const handleClick = (activity) => {
        Modal.confirm({
            title: '审核意见',
            content:<div>
                <Radio.Group
                    onChange={(e) => {activity.status = e.target.value;}}
                    defaultValue={'已通过'}
                >
                    <Radio value={'已通过'}>通过</Radio>
                    <Radio value={'已驳回'}>驳回</Radio>
                </Radio.Group>
                <br/>
                <Input
                    type="text"
                    placeholder="审核意见"
                    onChange={(e) => {
                        activity.feedback = e.target.value;
                    }}
                />
            </div>,
            okText: '确定',
            cancelText: '取消',
            closable: true,
            icon: null,
            onOk: () => {
                activity.status === '待审核' ? activity.status = '已通过' : activity.status = '已驳回';
                console.log(activity.status);
                // 当前活动状态发到后端

            },
            onCancel:() => {
                activity.status = '待审核';
            }
        });
    };

    return (
        <div>
            <Card
                style={{ width: '100%' }}
                title={activity.name}
                tabList={tabList}
                activeTabKey={activeTabKey}
                onTabChange={onTabChange}
                tabBarExtraContent={activity.status === '待审核' ?
                    <Button type="primary" onClick={() => handleClick(activity)}>
                        审核
                    </Button>
                    :
                    <div>
                        反馈：{activity.feedback}
                    </div>}
            >
                {contentList[activeTabKey]}
            </Card>
        </div>
    );
}

export default ManageActivityView;


