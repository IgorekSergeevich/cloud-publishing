import React from "react";
import { Route, Switch } from "react-router-dom";
import { Articles } from "../pages/Articles.jsx";
import { PublishingAppBar } from "../PublishingAppBar.jsx";
import { makeStyles } from "@material-ui/core/styles";
import Toolbar from "@material-ui/core/Toolbar";
import Paper from "@material-ui/core/Paper";
import { EmployeePage } from "../pages/employees/EmployeePage.jsx";

const useStyles = makeStyles((theme) => ({
    content: {
        flexGrow: 1
    },
    paper: {
        margin: theme.spacing(3),
        padding: theme.spacing(3)
    }
}));


export const MainLayout = (props) => {
    const classes = useStyles();
    return (
        <>
            <PublishingAppBar />
            <main className={classes.content}>
                <Toolbar />
                <Paper className={classes.paper}>
                    <Switch>
                        <Route path="/employees" component={EmployeePage} />
                        <Route path="/articles" component={Articles} />
                    </Switch>
                </Paper>
            </main>

        </>
    );
}