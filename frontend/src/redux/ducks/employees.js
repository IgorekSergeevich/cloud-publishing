import { employeeAPI } from "../../api/employee-api";

const LOADING_EMPLOYEES = "cloud-publishing/employees/LOADING_EMPLOYEES";
const EMPLOYEES_LOADED = "cloud-publishing/employees/EMPLOYEES_LOADED";
const DELETING_EMPLOYEE = "cloud-publishing/employees/DELETING_EMPLOYEE";
const EMPLOYEE_DELETED = "cloud-publishing/employees/EMPLOYEE_DELETED";
const CREATING_EMPLOYEE = "cloud-publishing/employees/CREATING_EMPLOYEE";
const EMPLOYEE_CREATED = "cloud-publishing/employees/EMPLOYEE_CREATED";

const initState = {
    employees: [],
    isFetching: false
};

export default (state = initState, action) => {
    switch (action.type) {
        case LOADING_EMPLOYEES:
            return { ...state, ... { isFetching: true } };
        case EMPLOYEES_LOADED:
            return { ...state, ... { isFetching: false, employees: action.employees } };
        case DELETING_EMPLOYEE:
            return { ...state, ... { isFetching: true } };
        case EMPLOYEE_DELETED:
            return {
                ...state,
                ... {
                    isFetching: false,
                    employees: state.employees.filter(e => e.id !== action.employeeId)
                }
            };
        case CREATING_EMPLOYEE:
            return {
                ...state, ...{ isFetching: true } 
            };
        case EMPLOYEE_CREATED:
            return {
                ...state, ...{ isFetching: false } 
            };
        default:
            return state;
    }
};

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

export const employeeCreatingAction = () => {
    return {
        type: CREATING_EMPLOYEE
    };
};

export const employeeCreatedAction = () => {
    return {
        type: EMPLOYEE_CREATED
    };
};

export const loadEmployees = () => (dispatch) => {
    dispatch(employeeLoadingAction());
    employeeAPI.getEmployeeList().then(e => dispatch(employeeLoadedAction(e)));
};

export const deleteEmployee = (employeeId) => (dispatch) => {
    dispatch(employeeDeletingAction());
    employeeAPI.deleteEmployeeByIdMock(employeeId)
        .then((id) => dispatch(employeeDeletedAction(id)));
};

export const createEmployee = (employee) => (dispatch) => {
    dispatch(employeeCreatingAction());
    employeeAPI.createEmployeeAccount(employee)
        .then(() => dispatch(employeeCreatedAction()));
};