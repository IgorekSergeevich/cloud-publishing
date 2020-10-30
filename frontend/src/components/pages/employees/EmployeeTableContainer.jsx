import React from "react";
import { EmployeeTable } from "./EmployeeTable.jsx";
import { loadEmployees } from "../../../redux/thunk/employee-thunk";
import { connect } from "react-redux";


class EmployeeTableContainer extends React.Component {

    componentDidMount() {
        this.props.loadEmployees();
    }

    render() {
        return <EmployeeTable employees={this.props.employees} isLoading={this.props.isLoading}/>;
    }
}

const mapStateToProps = (state) => {
    return {
        employees: state.employee.employees,
        isLoading: state.employee.isLoading
    }
};

const mapDispatchToProps = {
    loadEmployees
};

const EmployeeTableConnectedContainer = 
    connect(mapStateToProps, mapDispatchToProps)(EmployeeTableContainer);

export {EmployeeTableConnectedContainer as EmployeeTableContainer};    