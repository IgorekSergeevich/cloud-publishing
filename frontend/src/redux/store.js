import { createStore, combineReducers, applyMiddleware } from "redux";
import appReducer from "./ducks/app";
import authReducer from "./ducks/auth";
import employeeReducer from "./ducks/employees";
import educationReducer from "./ducks/educations";
import thunkMiddleware from "redux-thunk";
import { reducer as formReducer } from "redux-form";

const reducers = {
    app: appReducer,
    auth: authReducer,
    employee: employeeReducer,
    educations: educationReducer,
    form: formReducer
};

const rootReducer = combineReducers(reducers);

export default createStore(rootReducer, applyMiddleware(thunkMiddleware));