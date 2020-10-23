import React from "react";
import { Link } from "react-router-dom";
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import MenuItem from '@material-ui/core/MenuItem';
import { keycloak } from "../auth/keycloak.js";
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
    title: {
        flexGrow: 1,
    },
}));

export const AppNavbar = () => {
    const classes = useStyles();

    return (
    <div className={classes.root}>
        <AppBar position="static">
            <Toolbar>
                <Typography variant="h6" className={classes.title}>
                    Cloud publishing
                </Typography>
                <MenuItem component={Link} to="/employees">Employees</MenuItem>
                <MenuItem component={Link} to="/articles">Articles</MenuItem>
                <Button color="inherit" onClick={() => keycloak.logout()}>Logout</Button>
            </Toolbar>
        </AppBar>
    </div>);
};