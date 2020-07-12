import React from "react";
import { connect } from "react-redux";
import { loginAction } from "../../actions/auth-actions.ts";
import { keycloak } from "./keycloak";
import { LoginLayout } from "../layouts/LoginLayout.jsx";
import { MainLayout } from "../layouts/MainLayout.jsx";

class AuthApp extends React.Component {

    componentDidMount() {
        keycloak.init({onLoad: "check-sso", promiseType: "native"})
            .then(isAuthorized => isAuthorized && 
                this.props.loginAction({userName: keycloak.idTokenParsed.name}));        
    }

    render() {
        return this.props.isAuthorized ? <MainLayout /> : <LoginLayout />;
    }
}

const mapStateToProps = state => {
    return {
        isAuthorized: state.auth.isAuthorized
    };
};

const mapDispatchToProps = {
    loginAction
};

const AuthAppContainer = connect(mapStateToProps, mapDispatchToProps)(AuthApp);

export { AuthAppContainer as AuthApp };