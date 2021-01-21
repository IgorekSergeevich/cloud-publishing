import { Provider } from "react-redux";
import store from "./redux/store";
import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import { App } from "./app.jsx";
import { checkAuth } from "./auth/keycloak-auth";
import CssBaseline  from "@material-ui/core/CssBaseline"


const render = (application) => {
    ReactDOM.render(
        application,
        document.getElementById("root")
    );
};

const startApp = async () => {

    await checkAuth();

    render(
        <Provider store={store}>
            <BrowserRouter>
                <CssBaseline />
                <App />
            </BrowserRouter>
        </Provider>
    );
};

startApp();