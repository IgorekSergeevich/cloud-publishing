import { createStore, combineReducers, applyMiddleware } from "redux";
import authReducer from "./ducks/auth.ts";
import employeeReducer from "./ducks/employees";
import educationReducer from "./ducks/educations";
import thunkMiddleware from "redux-thunk";
import { reducer as formReducer } from "redux-form";

const reducers = {
    auth: authReducer,
    employee: employeeReducer,
    educations: educationReducer,
    form: formReducer
};

const rootReducer = combineReducers(reducers);

export default createStore(rootReducer, applyMiddleware(thunkMiddleware));