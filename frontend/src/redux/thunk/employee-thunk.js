import { employeeLoadedAction, employeeLoadingAction } from "../../actions/employees-actions";
import { getEmployeeListMock } from "../../api/employee-api";

export const loadEmployees = () => (dispatch) => {
    dispatch(employeeLoadingAction());
    getEmployeeListMock().then(e => dispatch(employeeLoadedAction(e)));
};