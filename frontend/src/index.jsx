import { Provider } from "react-redux";
import store from "./redux/store";
import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import { App } from "./App.jsx";
import { checkAuth } from "./auth/keycloak-auth";
import { AppLayout } from "./components/layouts/AppLayout.jsx";

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
                <AppLayout>
                    <App />
                </AppLayout>
            </BrowserRouter>
        </Provider>
    );
};

startApp();