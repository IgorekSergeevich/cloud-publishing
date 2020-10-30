import { LOADING_EMPLOYEES, EMPLOYEES_LOADED } from "../../actions/action-types";

const initState = {
    employees: [],
    isLoading: false
};

export const employeeReducer = (state = initState, action) => {
    switch (action.type) {
        case LOADING_EMPLOYEES:
            return {...state, ... { isLoading: true } };
        case EMPLOYEES_LOADED:
            return {...state, ... { isLoading: false, employees: action.employees } };
        default:
            return state;
    }
};