import React from "react";
import { MainLayout } from "./components/layouts/MainLayout.jsx";
import { LoginLayout } from "./components/layouts/LoginLayout.jsx";
import { connect } from "react-redux";
import { Container } from "react-bootstrap";

const App = (props) => {

    return (
        <Container>
            { props.isAuthorized ? <MainLayout /> : <LoginLayout /> }
        </Container>);
};

const mapStateToProps = (state) => {
    return {
        isAuthorized: state.auth.isAuthorized
    };
};

const AppContainer = connect(mapStateToProps)(App);

export { AppContainer as App };