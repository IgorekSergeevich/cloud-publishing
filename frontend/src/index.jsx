import { Provider } from "react-redux";
import store from "./redux/store";
import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import App from "./app.jsx";
import CssBaseline from "@material-ui/core/CssBaseline";


const Application = (
    <Provider store={store}>
        <BrowserRouter>
            <CssBaseline />
            <App />
        </BrowserRouter>
    </Provider>
);


ReactDOM.render(Application, document.getElementById("root"));

if (module.hot) {
    module.hot.accept()
}