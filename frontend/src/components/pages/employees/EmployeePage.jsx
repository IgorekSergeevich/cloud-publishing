import React from "react";
import { Employees } from "./sections/Employees.jsx";
import { NewEmployee } from "./sections/NewEmployee.jsx";
import { Route, Switch } from "react-router-dom";
import { PrivateRoute } from "../../routes/PrivateRoute.jsx";

export const EmployeePage = ({ match }) => {

  return (
    <Switch>
      <PrivateRoute path={`${match.path}/new`} component={NewEmployee} />
      <PrivateRoute component={Employees} />
    </Switch>
  );
}
