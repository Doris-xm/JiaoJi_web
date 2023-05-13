import { Layout, Menu, Input } from "antd";
import React, {useState} from "react";
import ActivityList from "../Component/ActivityList";
import PersonView from "./PersonView";
import ActivityView from "./ActivityView";

const { Header, Content } = Layout;
const { Search } = Input;

const items = [
    {
        label: "活动大厅",
        key: "home",
        content: <ActivityView/>,
    },
    {
        label: "个人中心",
        key: "person",
        content: <PersonView/>,
    },
    {
        label: "管理活动",
        key: "manage",
        content:<PersonView/>,
    },
    {
        label: "聊天室",
        key: "chat",
        content: <PersonView/>,
    },
];

/**
 * @description: 活动页面
 * 顶部菜单栏+活动列表
 * 包含组件ActivityList：活动列表
 * 页面跳转未完成
 */
const HomeView = () => {
    const [selectedKey, setSelectedKey] = useState("home");

    const handleMenuClick = ({ key }) => {
        setSelectedKey(key);
    };
    return (
        <div>
            <Layout>
                <Header>
                    <Menu
                        theme="dark"
                        mode="horizontal"
                        selectedKeys={[selectedKey]}
                        onClick={handleMenuClick}
                        defaultSelectedKeys={["home"]}
                        style={{ lineHeight: "64px" }}
                    >
                        {items.map((item) => (
                            <Menu.Item key={item.key}>{item.label}</Menu.Item>
                        ))}
                    </Menu>
                </Header>
                <Content style={{ padding: 10 }} className="home-content">
                    <div className="home-content">
                        {items.map((item) =>
                            item.key === selectedKey ? item.content : null
                        )}
                    </div>
                </Content>
            </Layout>
        </div>
    );
};

export default HomeView;