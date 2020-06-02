import React from "react";
import { withAuthorize } from "../../auth/auth-provider.jsx";
import { Redirect } from "react-router-dom";

export const LoginForm = withAuthorize(({ isAuthorise, authorize }) => 
    isAuthorise ? 
    (<Redirect to="/public" />) : 
    (<div>
        <h1>Login</h1>
        <button onClick={authorize}>LogIn</button>
    </div>));