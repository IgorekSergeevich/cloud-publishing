import React from "react";
import { NewEmployeeForm } from "../forms/EmployeeForm.jsx";

import { connect } from "react-redux";
import { createEmployee } from "../../../../redux/ducks/employees"


const NewEmployee = ({ createEmployee, isCreating }) => {

    return (
        <>
            {isCreating ?
                <h1>Creating...</h1> : <NewEmployeeForm onSubmit={createEmployee} />
            }
        </>);
};

const mapStateToProps = (state) => ({
    isCreating: state.employee.isFetching
});

const mapDispatchToProps = {
    createEmployee
};

const NewEmployeeContainer = connect(mapStateToProps, mapDispatchToProps)(NewEmployee);

export { NewEmployeeContainer as NewEmployee };