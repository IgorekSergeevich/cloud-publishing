import { createStore, combineReducers, applyMiddleware } from "redux";
import { authReducer } from "./reducers/auth-reducer.ts";
import { employeeReducer } from "./reducers/employees-reducer";
import thunkMiddleware from "redux-thunk";

const reducers = {
    auth: authReducer,
    employee: employeeReducer
};

const rootReducer = combineReducers(reducers);

export default createStore(rootReducer, applyMiddleware(thunkMiddleware));