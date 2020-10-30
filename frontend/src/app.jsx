import React from "react";
import { MainLayout } from "./components/layouts/MainLayout.jsx";
import { connect } from "react-redux";
import { Home } from "./components/pages/Home.jsx";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
    root: {
        display: "flex"
    }
}));

const App = (props) => {

    const classes = useStyles();
    return (
        <div className={classes.root}>
            { props.isAuthorized ? <MainLayout /> : <Home /> }
        </div>);
};

const mapStateToProps = (state) => {
    return {
        isAuthorized: state.auth.isAuthorized
    };
};

const AppContainer = connect(mapStateToProps)(App);

export { AppContainer as App };