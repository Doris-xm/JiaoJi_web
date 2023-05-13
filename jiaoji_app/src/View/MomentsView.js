import {Button, Card, Layout} from 'antd';
import React, { useState } from 'react';
import MomentCard from "../Component/MomentCard";
import {Content, Header} from "antd/es/layout/layout";
import '../css/backgroud.css'
import { InboxOutlined, PlusOutlined} from "@ant-design/icons";

const { Meta } = Card;

const MomentList = [
    {
        id: 1,
        title: 'David',
        description: 'Hello world.',
        avatar: 'https://xsgames.co/randomusers/avatar.php?g=pixel&key=1',
        photo:"https://s1.ax1x.com/2023/05/01/p9Gu41g.jpg",
    },
    {
        id: 2,
        title: 'Amy',
        description: 'NICE DAY!',
        avatar: 'https://xsgames.co/randomusers/avatar.php?g=pixel&key=2',
        photo:"https://s1.ax1x.com/2023/05/01/p9GKNuj.jpg",
    },
    {
        id: 3,
        title: 'Doris',
        description: 'MAYDAY!',
        avatar: 'https://xsgames.co/randomusers/avatar.php?g=pixel&key=3',
        photo:"https://s1.ax1x.com/2023/05/01/p9Gu41g.jpg",
    },
];

/**
 * @description: 朋友圈页面
 * 菜单栏右侧部分
 * 包含组件Header：两个按钮，发布、接收消息
 * 包含组件MomentCard：朋友圈卡片
 */
const MomentsView: React.FC = () => {


    return (
        <Layout style={{
            background: "transparent",
            display: "flex",
            alignItems: "center",
        }}>
            <Header style={{
                padding: 10,
                background: "rgba(255,255,255,0.5)",
                width: "80%",
                display: "flex",
                justifyContent: "space-between",
            }}
            >
                {/* eslint-disable-next-line react/jsx-no-undef */}
                <Button style={{backgroundColor:"rgba(255,255,255,0.5)"}} type="default" shape="circle" icon={<PlusOutlined />} size={'middle'} />
                <Button style={{backgroundColor:"rgba(255,255,255,0.5)"}} type="default" shape="circle" icon={<InboxOutlined />} size={'middle'} />
            </Header>

            <Content >
                <div>
                    {MomentList.map((moment) => (
                        <MomentCard moment={moment} />
                    ))}
                </div>
            </Content>
        </Layout>

    );
};

export default MomentsView;