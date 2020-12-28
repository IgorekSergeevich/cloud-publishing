import React from "react";
import { EmployeeTableContainer } from "../tables/EmployeeTableContainer.jsx";
import Button from '@material-ui/core/Button';
import Toolbar from '@material-ui/core/Toolbar'
import { makeStyles } from '@material-ui/core/styles';
import AddIcon from '@material-ui/icons/Add';
import { Link } from 'react-router-dom';
import { green } from '@material-ui/core/colors';

const useStyle = makeStyles(theme => ({
  employeeButton: {
    position: "absolute",
    right: "10px",
    backgroundColor: green[300],
    color: green[50],
    '&:hover': {
      backgroundColor: green[400],
    }
  }
}));

export const Employees = () => {
  const classes = useStyle();

  return (
    <>
      <Toolbar>
        <Button component={Link} to="employees/new"
          variant="outlined"
          size="large"
          className={classes.employeeButton}>
          <AddIcon /> Add new employee
        </Button>
      </Toolbar>
      <EmployeeTableContainer />
    </>);
}