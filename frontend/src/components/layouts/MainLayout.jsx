import React from "react";
import { Route, Switch } from "react-router-dom";
import { Articles } from "../pages/Articles.jsx";
import { PublishingAppBar } from "../PublishingAppBar.jsx";
import { Employees } from "../pages/employees/Employees.jsx";
import { makeStyles } from "@material-ui/core/styles";
import Toolbar from "@material-ui/core/Toolbar";

const useStyles = makeStyles((theme) => ({
    content: {
        padding: theme.spacing(3),
        flexGrow: 1
    }
}));

export const MainLayout = (props) => {
    const classes = useStyles();
    return (
        <>
            <PublishingAppBar />
            <main className={classes.content}>
                <Toolbar />
                <Switch>
                    <Route path="/employees" component={Employees} />
                    <Route path="/articles" component={Articles} />
                </Switch>
            </main>

        </>
    );
}