import React from "react";
import { Route } from "react-router-dom";
import UserListContainer from "../../containers/user-list-container.jsx";
import WidgetListContainer from "../../containers/widget-list-container.jsx";

export default (props) => {
    return (
        <div>
            <header>
                <h2>{props.searchType}</h2>
            </header>
            <section>
                <Route path="/users" component={UserListContainer}/>
                <Route path="/widgets" component={WidgetListContainer}/>
            </section>
            <footer>
                <span>{props.searchAmount}</span>
            </footer>
        </div>
    );
}