import React from "react";
import { withAuthorize } from "./auth-provider.jsx";
import { Route, Redirect } from "react-router-dom";


export const PrivateRoute = withAuthorize(({ isAuthorise, component: RoutComponent, ...rest }) => (
    <Route {...rest} render={routProps => isAuthorise ?
        (<RoutComponent {...routProps} />) 
        : (<Redirect to="/login" />)
    }/>
));