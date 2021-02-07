import React from "react";
import { Route, Redirect } from "react-router-dom";
import { connect } from "react-redux";


const PublicRoute = ({ component: Component, isAuthorized, ...rest }) => (
    <Route {...rest} render={(props) => (
        !isAuthorized ? <Component {...props} /> : <Redirect to="/home" />
    )} />
);

const mapStateToProps = (state) => ({
    isAuthorized: state.auth.isAuthorized
});

const PublicRouteContainer = connect(mapStateToProps)(PublicRoute);

export { PublicRouteContainer as PublicRoute };