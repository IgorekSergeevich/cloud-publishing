import React, { useCallback, useEffect } from "react";
import { MainLayout } from "./components/layouts/MainLayout.jsx";
import { makeStyles } from "@material-ui/core/styles";
import Paper from '@material-ui/core/Paper';
import { PrivateRoute } from "./components/routes/PrivateRoute.jsx";
import { Switch } from "react-router-dom";
import { Articles } from "./components/pages/Articles.jsx";
import { EmployeePage } from "./components/pages/employees/EmployeePage.jsx";
import { connect } from "react-redux";
import { initializeApp } from "./redux/ducks/app"
import { AppPreloader } from "./components/commons/AppPreloader.jsx";


const useStyles = makeStyles((theme) => ({
    paper: {
        margin: theme.spacing(3),
        padding: theme.spacing(3)
    }
}));


const App = ({ isInitialized, initializeApp }) => {
    const cl = useStyles();

    const initialize = useCallback(() => {
        initializeApp()
    }, []);

    useEffect(() => initialize(), [initialize]);

    return (
        <>
            {!isInitialized ? (
                <AppPreloader />
            ) : (
                    <MainLayout>
                        <Paper className={cl.paper}>
                            <Switch>
                                <PrivateRoute path="/employees" component={EmployeePage} />
                                <PrivateRoute path="/articles" component={Articles} />
                            </Switch>
                        </Paper>
                    </MainLayout>)}
        </>
    );
};

const mapStateToProps = (state) => ({
    isInitialized: state.app.isInitialized
});

const mapDispatchToProps = {
    initializeApp
};

export default connect(mapStateToProps, mapDispatchToProps)(App);