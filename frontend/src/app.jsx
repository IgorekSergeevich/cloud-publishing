import React from "react";
import { MainLayout } from "./components/layouts/MainLayout.jsx";
import { connect } from "react-redux";
import { Home } from "./components/pages/Home.jsx";

const App = (props) => {

    return (
        <>
            { props.isAuthorized ? <MainLayout /> : <Home /> }
        </>);
};

const mapStateToProps = (state) => {
    return {
        isAuthorized: state.auth.isAuthorized
    };
};

const AppContainer = connect(mapStateToProps)(App);

export { AppContainer as App };