import { createStore, combineReducers } from "redux";
import { authReducer } from "./reducers/auth-reducer.ts";

const reducers = {
    auth: authReducer
};

const rootReducer = combineReducers(reducers);

export default createStore(rootReducer);
