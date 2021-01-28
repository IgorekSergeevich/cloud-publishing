import React from "react";
import { MainLayout } from "./components/layouts/MainLayout.jsx";
import { makeStyles } from "@material-ui/core/styles";
import Paper from '@material-ui/core/Paper';
import { PrivateRoute } from "./components/routes/PrivateRoute.jsx";
import { Switch } from "react-router-dom";
import { Articles } from "./components/pages/Articles.jsx";
import { EmployeePage } from "./components/pages/employees/EmployeePage.jsx";
import CssBaseline  from "@material-ui/core/CssBaseline";


const useStyles = makeStyles((theme) => ({
    paper: {
        margin: theme.spacing(3),
        padding: theme.spacing(3)
    }
}));


export const App = () => {

    const cl = useStyles();

    return (
        <>
            <CssBaseline />
            <MainLayout>
                <Paper className={cl.paper}>
                    <Switch>
                        <PrivateRoute path="/employees" component={EmployeePage} />
                        <PrivateRoute path="/articles" component={Articles} />
                    </Switch>
                </Paper>
            </MainLayout>
        </>
    );
};