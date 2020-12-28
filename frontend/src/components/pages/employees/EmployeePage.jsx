import React from "react";
import { Employees } from "./sections/Employees.jsx";
import { NewEmployee } from "./sections/NewEmployee.jsx";
import { Route, Switch } from "react-router-dom";

export const EmployeePage = ({ match }) => {

  return (
    <Switch>
      <Route path={`${match.path}/new`}
        render={(props) => <NewEmployee/>} />
      <Route component={Employees} />
    </Switch>
  );
}
