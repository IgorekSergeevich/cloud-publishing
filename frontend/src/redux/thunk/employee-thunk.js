import {
    employeeLoadedAction,
    employeeLoadingAction,
    employeeDeletingAction,
    employeeDeletedAction
} from "../../actions/employees-actions";
import { getEmployeeListMock, deleteEmployeeByIdMock } from "../../api/employee-api";

export const loadEmployees = () => (dispatch) => {
    dispatch(employeeLoadingAction());
    getEmployeeListMock().then(e => dispatch(employeeLoadedAction(e)));
};

export const deleteEmployee = (employeeId) => (dispatch) => {
    dispatch(employeeDeletingAction());
    deleteEmployeeByIdMock(employeeId)
        .then((id) => dispatch(employeeDeletedAction(id)));
};