import { postRequest, postRequest_v2 } from "../utils/ajax";
import { history } from "../utils/history";
import { message } from "antd";
import { useNavigate } from "react-router-dom";

export const login = (data) => {
    const url = `http://localhost:8003/login`;
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

export const getUserByUserId = (userId, callback) => {
    const data = { userId: userId };
    console.log("getUserByUserId", data);
    const url = `http://localhost:8003/get_user`;

    postRequest(url, data, callback);
};

export const createUser = (data, callback) => {
    return null;
};