// 0617
import { Button, Empty, List, Avatar, Card, Image, Space } from 'antd';
import { useState } from 'react';
import { getUserByUserId } from '../../Services/UserService';

const UserInfo = () => {
    const user = JSON.parse(localStorage.getItem('user'));

    const data = [
        {
            title: '用户名',
            description: user.username,
        },
        {
            title: '昵称',
            description: user.nickname,
        },
        {
            title: '年级',
            description: user.grade,
        },
        {
            title: '性别',
            description: user.gender === 0 ? '女' : '男',
        },
        {
            title: '邮箱',
            description: user.mail,
        },
        {
            title: '电话',
            description: user.phone,
        },
    ];

    return (
        <div>
            {!user ? (
                <Empty>
                    <Button href="/login">点击登录</Button>
                </Empty>
            ) : (
                <div>
                    <Card
                        bodyStyle={{
                            display: 'flex',
                            alignItems: 'center',
                            width: '100%',
                        }}
                    >
                        <img
                            src={user.avatar}
                            alt="头像"
                            style={{
                                width: "30%",
                                marginRight: '100px',
                            }}
                        />
                        <List
                            itemLayout="horizontal"
                            dataSource={data}
                            style={{ width: '100%' }}
                            renderItem={(item) => (
                                <List.Item style={{ width: '100%' }}>
                                    <div
                                        style={{
                                            display: 'flex',
                                            alignItems: 'center',
                                            justifyContent: 'space-between',
                                        }}
                                    >
                                        <div style={{ fontSize: '16px', fontWeight: 'bold' }}>
                                            {item.title}
                                        </div>
                                        <div style={{ marginLeft: '16px', fontSize: '14px' }}>
                                            {item.description}
                                        </div>
                                    </div>
                                </List.Item>
                            )}
                        />
                    </Card>
                    <br />
                    <br />
                </div>
            )}
        </div>
    );
};

export default UserInfo;
