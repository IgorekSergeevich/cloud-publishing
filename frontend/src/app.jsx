import ReactDOM from "react-dom";
import router from "./router.jsx";
import {Provider} from "react-redux";
import store from "./store";
import React from "react";

ReactDOM.render(
    <Provider store={store}>{router}</Provider>,
    document.getElementById("root")
);