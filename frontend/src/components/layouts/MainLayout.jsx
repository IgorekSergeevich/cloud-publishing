import React from "react";
import { PublishingAppBar } from "../PublishingAppBar.jsx";
import { makeStyles } from "@material-ui/core/styles";
import Toolbar from "@material-ui/core/Toolbar";


const useStyles = makeStyles((theme) => ({
    root: {
        display: "flex"
    },
    content: {
        flexGrow: 1
    }
}));


export const MainLayout = ({children}) => {
    const classes = useStyles();
    return (
        <div className={classes.root}>
            <PublishingAppBar />
            <div className={classes.content}>
                <Toolbar />
                {children}
            </div>
        </div>
    );
}