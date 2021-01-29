import React, { useState } from "react";
import MenuItem from '@material-ui/core/MenuItem';
import Menu from '@material-ui/core/Menu';
import IconButton from '@material-ui/core/IconButton';
import { keycloak } from "../auth/keycloak-auth.js";
import Avatar from '@material-ui/core/Avatar';
import { makeStyles } from '@material-ui/core/styles';
import { connect } from "react-redux";

const useStyles = makeStyles((theme) => ({
    emptyAvatar: {
        color: "black",
        backgroundColor: "white"
    }
}));


const AppBarMenu = ({ userName, photoUrl }) => {

    const [anchorEl, setAnchorEl] = useState(null);
    const open = Boolean(anchorEl);
    const cl = useStyles();

    const handleMenu = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    return (
        <div>
            <IconButton
                aria-label="account of current user"
                aria-controls="menu-appbar"
                aria-haspopup="true"
                onClick={handleMenu}
                color="inherit"
            >
                <Avatar className={cl.emptyAvatar} src={photoUrl}>
                    {!photoUrl && userName[0]}
                </Avatar>
            </IconButton>
            <Menu
                id="menu-appbar"
                anchorEl={anchorEl}
                anchorOrigin={{
                    vertical: 'top',
                    horizontal: 'right',
                }}
                keepMounted
                transformOrigin={{
                    vertical: 'top',
                    horizontal: 'right',
                }}
                open={open}
                onClose={handleClose}
            >
                <MenuItem onClick={() => location.replace("http://localhost:8180/auth/realms/cloud-publishing/account/")}>
                    Account managment
                </MenuItem>
                <MenuItem onClick={() => keycloak.logout()}>Logout</MenuItem>
            </Menu>
        </div>
    );
};

const mapStateToProps = (state) => ({
    userName: state.auth.userName,
    photoUrl: state.auth.photoUrl
});

const AppBarMenuContainer = connect(mapStateToProps)(AppBarMenu);

export { AppBarMenuContainer as AppBarMenu };