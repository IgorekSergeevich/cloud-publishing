import { createStore, combineReducers, applyMiddleware } from "redux";
import authReducer from "./ducks/auth.ts";
import employeeReducer from "./ducks/employees";
import thunkMiddleware from "redux-thunk";

const reducers = {
    auth: authReducer,
    employee: employeeReducer
};

const rootReducer = combineReducers(reducers);

export default createStore(rootReducer, applyMiddleware(thunkMiddleware));