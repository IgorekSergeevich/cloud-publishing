import React from "react";
import { EmployeesList } from "./EmployeesList.jsx";
import { Route, Switch } from "react-router-dom";
import { ReduxEmployeeForm as EmployeeForm } from "./EmployeeForm.jsx";

export const Employees = ({match}) => {

  return (
    <Switch>
      <Route path={`${match.path}/new`} 
          render={(props) => <EmployeeForm {...props} onSubmit={(data) => console.log(data)} /> }/>
      <Route component={EmployeesList} />
    </Switch>
  );
}
