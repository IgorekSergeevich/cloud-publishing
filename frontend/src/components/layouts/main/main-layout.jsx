import React from "react";
import {NavLink} from "react-router-dom";

export default (props) => {
    return (
        <div>
            <nav>
                <ul>
                    <li>
                        <NavLink to="/" exact>Home</NavLink>
                    </li>
                    <li>
                        <NavLink to="/users">Users</NavLink>
                    </li>
                    <li>
                        <NavLink to="/widgets">Widgets</NavLink>
                    </li>
                    <li>
                        <NavLink to="/public">Public</NavLink>
                    </li>
                    <li>
                        <NavLink to="/private">Private</NavLink>
                    </li>
                    <li>
                        <NavLink to="/login">Login</NavLink>
                    </li>
                </ul>
            </nav>
            <div>
                {props.children}
            </div>
        </div>
    );
}