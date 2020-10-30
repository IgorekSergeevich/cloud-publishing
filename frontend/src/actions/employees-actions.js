import { EMPLOYEES_LOADED, LOADING_EMPLOYEES } from "./action-types"

export const employeeLoadingAction = () => {
    return {
        type: LOADING_EMPLOYEES
    };
}

export const employeeLoadedAction = (employees) => {
    return {
        type: EMPLOYEES_LOADED,
        employees
    };
}