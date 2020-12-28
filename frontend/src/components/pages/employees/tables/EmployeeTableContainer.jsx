import React from "react";
import { EmployeeTable } from "./EmployeeTable.jsx";
import { loadEmployees, deleteEmployee } from "../../../../redux/ducks/employees";
import { connect } from "react-redux";


class EmployeeTableContainer extends React.Component {

    componentDidMount() {
        this.props.loadEmployees();
    }

    render() {
        return (
            <EmployeeTable employees={this.props.employees}
                isFetching={this.props.isFetching}
                deleteEmployee={this.props.deleteEmployee}/>);
    }
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