import ReactDOM from "react-dom";
import { Provider } from "react-redux";
import store from "./redux/store";
import React from "react";
import { BrowserRouter } from "react-router-dom";
import { Container, Row } from "react-bootstrap";
import { AuthApp } from "./components/auth/AuthApp.jsx";

const App =
    (<Provider store={store}>
        <BrowserRouter>
            <Container>
                <AuthApp />
            </Container>
        </BrowserRouter>
    </Provider>);


ReactDOM.render(
    App,
    document.getElementById("root")
);