import React, { useState } from "react";
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import { keycloak } from "../auth/keycloak-auth.js";
import { makeStyles } from '@material-ui/core/styles';
import { connect } from "react-redux";
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import { Navigation } from "./Navigation.jsx";
import { AppBarMenu } from "./AppBarMenu.jsx";

const useStyles = makeStyles((theme) => ({
    appBar: {
        zIndex: theme.zIndex.drawer + 1
    },
    title: {
        flexGrow: 1
    }
}));

const PublishingAppBar = ({ isAuthorized, userName }) => {
    const classes = useStyles();
    const [isNavOpen, setIsNavOpen] = useState(false);

    return (
        <>
            <AppBar position="fixed" className={classes.appBar}>
                <Toolbar>
                    {isAuthorized ?
                        (<IconButton
                            aria-label="open menu"
                            onClick={() => setIsNavOpen(!isNavOpen)}
                            edge="start"
                        >
                            <MenuIcon />
                        </IconButton>) : (<></>)
                    }
                    <Typography variant="h6" className={classes.title}>
                        Cloud publishing
                    </Typography>
                    {isAuthorized ?
                        (
                            <AppBarMenu userName={userName}/>
                        ) : (
                            <Button color="inherit" onClick={() => keycloak.login()}>login</Button>
                        )
                    }
                </Toolbar>
            </AppBar>
            {isAuthorized ? <Navigation open={isNavOpen} /> : <></>}
        </>);
};

const mapStateToProps = (state) => ({
    isAuthorized: state.auth.isAuthorized,
    userName: state.auth.userName
});

const ConnectedPublishingAppBar = connect(mapStateToProps)(PublishingAppBar);
export { ConnectedPublishingAppBar as PublishingAppBar };