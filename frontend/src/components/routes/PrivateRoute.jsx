import React from "react";
import { Route, Redirect } from "react-router-dom";
import { connect } from "../../auth/react-redux";


const PrivateRoute = ({ component : Component, isAthorized, ...rest }) => {
    return <Route {...rest} render={(props) => {
        return isAthorized ? <Component {...props} /> : <Redirect to="/login" />;
    }}/>;
   
}

const mapStateToProps = (state) => {
    return {
        isAthorized: state.auth.isAthorized
    };
}

const PrivateRouteContainer = connect(mapStateToProps)(PrivateRoute);

export { PrivateRouteContainer as PrivateRoute};