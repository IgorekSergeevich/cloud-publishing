import React from "react";
import { NewEmployeeForm } from "../forms/EmployeeForm.jsx";
import { makeStyles } from '@material-ui/core/styles';
import Paper from "@material-ui/core/Paper";
import { connect } from "react-redux";
import { createEmployee } from "../../../../redux/ducks/employees"



const cl = makeStyles((theme) => ({
    root: {
        margin: theme.spacing(6),
        padding: theme.spacing(6)
    }
}));


const NewEmployee = ({ createEmployee, isCreating }) => {

    return (
        <>
            <Paper className={cl.root} elevation={3}>
                {isCreating ? 
                    <h1>Creating...</h1> : <NewEmployeeForm onSubmit={createEmployee} />
                }
            </Paper>
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