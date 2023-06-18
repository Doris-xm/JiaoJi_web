import React, { useState, useEffect } from "react";
import { getMyActivities, getMyReleaseActivities, getActivityByID } from "../../Services/ActivitySevice";
import {Button, Card, Drawer, List, message, Modal, Table} from "antd";
import { Link, useNavigate, useParams } from "react-router-dom";
import { getUser } from "../../Services/UserService";
import { getSignedUser } from "../../Services/ReleaseService";
import ReleaseForm from "../../Component/ReleaseForm";

const default_url = "https://th.bing.com/th/id/R.785580b0aa9cce1c7e016db5ee2e078e?rik=ebpuQj03uKxGQg&riu=http%3a%2f%2fphotos.tuchong.com%2f255820%2ff%2f2852945.jpg&ehk=8sZ0LLnnaIXhdwT1M5Zk2xrfIMFcE%2bV45Nc1839Gj7Y%3d&risl=&pid=ImgRaw&r=0";

const states = ["被驳回","审核中", "已发布", "已发布", "已发布", "已发布", "已发布"]; // state ENUM('Signed','Passed','Rejected','Participated','Commented'),

const MyRelease = () => {
    const [myActivities, setMyActivities] = useState([]);
    const [showTable, setShowTable] = useState(false);
    const [tableData, setTableData] = useState([]);
    const userSigned = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const userId = getUser().userId;
            const fetchedActivities = await getMyReleaseActivities(userId);

            const completeActivities = await Promise.all(
                fetchedActivities.map(async (activity) => {
                    const completeActivity = await getActivityByID(activity.actId);
                    return { ...completeActivity };
                })
            );

            setMyActivities(completeActivities);
        };

        fetchData();
    }, []);

    const handleGetUser = (actId) => {
        getSignedUser(actId, (data, error) => {
            if (data) {
                setTableData(data);
                setShowTable(true);
            } else {
                console.log("获取学生信息失败", error);
            }
        });
    };

    const onClose = () => {
        setShowTable(false);
    };

    const columns = [
        {
            title: "用户ID",
            dataIndex: "userId",
            key: "userId",
        },
        {
            title: "用户名",
            dataIndex: "username",
            key: "username",
        },
        {
            title: "学号",
            dataIndex: "studentId",
            key: "studentId",
        },
        {
            title: "学院",
            dataIndex: "college",
            key: "college",
        },
        {
            title: "年级",
            dataIndex: "grade",
            key: "grade",
        },
        {
            title: "社团",
            dataIndex: "club",
            key: "club",
        },
        {
            title: "邮箱",
            dataIndex: "mail",
            key: "mail",
        },
    ];


    return (
        <div>
            <ReleaseForm />
            <List
                style={{ margin: "20px" }}
                grid={{ gutter: 16, column: 4 }}
                dataSource={myActivities}
                pagination={{
                    onChange: (page) => {
                        console.log(page);
                    },
                    pageSize: 16,
                }}
                renderItem={(activity) => (
                    <List.Item>
                        <Link to={`/activity/${activity.id}`}>
                            <Card
                                cover={<img alt={default_url} src={activity.photo ? activity.photo : default_url} style={{ width: "95%", margin: "0 auto" }} />}
                                title={activity.name}
                            >
                                <Card.Meta description={activity.description} />
                                活动时间：{activity.activityTime}
                                活动时间：{activity.activityTime}
                                <br />
                                <br />
                                状态： {states[activity.status]}
                                <br />
                                <br />
                                {activity.status === 0 && <text>审核意见：{activity.comments}</text>}
                            </Card>
                        </Link>
                        <Button onClick={() => handleGetUser(activity.id)}
                                style={{margin:"18px 10px 10px 95px"}}>报名学生信息</Button>
                    </List.Item>
                )}
            />
            <Drawer
                title="报名学生信息"
                placement="bottom"
                closable={false}
                open={showTable}
                onClose={onClose}
            >
                <Table
                    dataSource={tableData}
                    columns={columns}
                    // Add other table props and styling as needed
                />
            </Drawer>
        </div>
    );
};

export default MyRelease;
