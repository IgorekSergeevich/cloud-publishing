import {
    LOADING_EMPLOYEES,
    EMPLOYEES_LOADED,
    DELETING_EMPLOYEE,
    EMPLOYEE_DELETED
} from "../../actions/action-types";

const initState = {
    employees: [],
    isFetching: false
};

export const employeeReducer = (state = initState, action) => {
    switch (action.type) {
        case LOADING_EMPLOYEES:
            return {...state, ... { isFetching: true } };
        case EMPLOYEES_LOADED:
            return {...state, ... { isFetching: false, employees: action.employees } };
        case DELETING_EMPLOYEE:
            return {...state, ... { isFetching: true } };
        case EMPLOYEE_DELETED:
            return {...state,
                ... {
                    isFetching: false,
                    employees: state.employees.filter(e => e.id !== action.employeeId)
                }
            };
        default:
            return state;
    }
};