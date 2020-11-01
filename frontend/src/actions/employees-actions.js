import {
    EMPLOYEES_LOADED,
    LOADING_EMPLOYEES,
    DELETING_EMPLOYEE,
    EMPLOYEE_DELETED
} from "./action-types";

export const employeeLoadingAction = () => {
    return {
        type: LOADING_EMPLOYEES
    };
};

export const employeeLoadedAction = (employees) => {
    return {
        type: EMPLOYEES_LOADED,
        employees
    };
};

export const employeeDeletingAction = () => {
    return {
        type: DELETING_EMPLOYEE,
    };
};

export const employeeDeletedAction = (employeeId) => {
    return {
        type: EMPLOYEE_DELETED,
        employeeId
    };
};