import React from "react";
import activities from "../Component/Activities";
import { Card as AntCard } from "antd";
import "../css/SignUp.css";
import SignUpForm from "../Component/SignUpForm";

const SignUp = ({ ActivityId }) => {
    const activity = activities[ActivityId - 1];

    function handleConfirmSignUp() {
        alert("报名信息已确认，报名成功！");
    }

    return (


        <div className="ant-card-body" >
            <SignUpForm onConfirmSignUp={handleConfirmSignUp} />

        </div>
    );
};

export default SignUp;
