import {Button, Card, Layout} from 'antd';
import React, { useState } from 'react';
import MomentCard from "../Component/Moment/MomentCard";
import {Content, Header} from "antd/es/layout/layout";
import '../css/backgroud.css'
import { InboxOutlined, PlusOutlined} from "@ant-design/icons";
import PostMoment from "../Component/Moment/PostMoment";
import {getPostedMoment} from "../Services/MomentService";
import {getUser, getUserById} from "../Services/UserService";
import moment from "moment/moment";
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
class MomentsView  extends React.Component {
    constructor(props) {
        super(props);
        this.state = { posters: [] };
    }

    async componentDidMount() {
        // const userId = getUser().userId;
        const fetchedPoster = await getPostedMoment();

        const posters = await Promise.all(
            fetchedPoster.map(async (value) => {
                const user = await getUserById(value.userId);
                return {
                    ...value,
                    avatar: user.avatar,
                    nickname: user.nickname
                };
            })
        );
        this.setState({posters: posters});
    }
    render() {
        return (
            <Layout style={{
                width:"100%",
                background: "transparent",
                display: "flex",
                flex:1,
                alignItems: "center",
            }}>
                <Header style={{
                    padding: 10,
                    background: "rgba(255,255,255,0.5)",
                    width: "60%",
                    display: "flex",
                    justifyContent: "space-between",
                    alignItems: "center",
                }}
                >
                    <PostMoment />
                </Header>

                <Content
                    style={{
                        display: "flex",
                        flex:1,
                        alignItems: "center",
                    }}>
                    <div style={{
                        width: "100%",
                        alignItems: "center",
                    }}>
                        {this.state.posters.map((moment) => (
                            <MomentCard moment={moment} />
                        ))}
                    </div>
                </Content>
            </Layout>

    );
    }
};

export default MomentsView;