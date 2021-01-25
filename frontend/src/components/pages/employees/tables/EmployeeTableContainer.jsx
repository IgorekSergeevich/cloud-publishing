import React, { useCallback, useEffect } from "react";
import { EmployeeTable } from "./EmployeeTable.jsx";
import { loadEmployees, deleteEmployee } from "../../../../redux/ducks/employees";
import { connect } from "react-redux";


const EmployeeTableContainer = (props) => {

    const loadAllEmployee = useCallback(() => {
        props.loadEmployees();
    }, []);

    useEffect(() => loadAllEmployee(), [loadAllEmployee]);

    return (
        <EmployeeTable employees={props.employees}
            isFetching={props.isFetching}
            deleteEmployee={props.deleteEmployee} />);

}

const mapStateToProps = (state) => {
    return {
        employees: state.employee.employees,
        isFetching: state.employee.isFetching
    };
};

const mapDispatchToProps = {
    loadEmployees,
    deleteEmployee
};

const EmployeeTableConnectedContainer =
    connect(mapStateToProps, mapDispatchToProps)(EmployeeTableContainer);

export { EmployeeTableConnectedContainer as EmployeeTableContainer };    