import React from "react";
import { Route, Switch } from "react-router-dom";
import { Employees } from "../pages/Employees.jsx";
import { Articles } from "../pages/Articles.jsx";
import { AppNavbar } from "../AppNavbar.jsx";

export const MainLayout = (props) => {

    return (
        <div>
            <AppNavbar />
            <div>
                <Switch>
                    <Route path="/employees" component={Employees} />
                    <Route path="/articles" component={Articles} />
                </Switch>
            </div>

        </div>
    );
}