import { postRequest, postRequest_v2 } from "../utils/ajax";
import { history } from "../utils/history";
import { message } from "antd";
import { useNavigate } from "react-router-dom";

/**
 * avatar :
 * club:
 * college:
 * mail:
 * gender:
 * nickname :
 * phone:
 * stu_id:
 * userId:
 * userType:
 * username:
 * */
export const login = (data) => {
    const url = `/api/login`;
    const callback = (data) => {
        if (data.status >= 0) {
            localStorage.setItem("user", JSON.stringify(data.data));
            history.push("/");
            window.location.reload();
            // navigate("/Homepage");
            // console.log(useHistory())
            message.success(data.msg);
        } else {
            message.error(data.msg);
        }
    };
    postRequest(url, data, callback);
};

export const getUser = () => {
    const user = localStorage.getItem("user");
    if (user) {
        return JSON.parse(user);
    } else {
        return null;
    }
};

export const createUser = (data) => {
    const url = `/api/newUser`;
    const callback = (data) => {
        if (data.status >= 0) {
            message.success(data.msg);
        } else {
            message.error(data.msg);
        }
    };
    postRequest(url, data, callback);
};

export const checkNewName = (data) => {
    const body = {
        username: data,
    };
    const url = `/api/checkUsername`;
    const callback = (data) => {
        return data.status >= 0;
    };
    return postRequest(url, body, callback);
};

export const  getUserById = async (userId) => {
    let user = null;
    try {
        const response = await fetch(`/api/user?userId=${userId}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        user = await response.json();
    } catch (error) {
        console.error("Error fetching user:", error);
    }
    return user;
};
