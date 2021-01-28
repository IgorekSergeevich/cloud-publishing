import React from "react";
import { Route, Redirect } from "react-router-dom";
import { connect } from "react-redux";


const PrivateRoute = ({ component: Component, isAuthorized, ...rest }) => {
    return <Route {...rest} render={(props) => {
        return isAuthorized ? <Component {...props} /> : <Redirect to="/" />;
    }} />;

}

const mapStateToProps = (state) => {
    return {
        isAuthorized: state.auth.isAuthorized
    };
}

const PrivateRouteContainer = connect(mapStateToProps)(PrivateRoute);

export { PrivateRouteContainer as PrivateRoute };