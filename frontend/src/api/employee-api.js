import { axiosInstance } from "./axios-instance";


export const employeeAPI = {

    getEmployeeList() {
        return axiosInstance.get("http://localhost:8080/employee/profiles")
            .then(response => response.data);
    },

    deleteEmployeeByIdMock(id) {
        return new Promise(resolve => {
            setTimeout(() => resolve(id), 1000);
        });
    },

    createEmployeeAccount(employee) {
        return axiosInstance.post(
            "http://localhost:8080/employee/new", employee);
    },

    loadShortProfile() {
        return axiosInstance.get(`http://localhost:8080/employee/shortProfile`)
            .then(response => response.data);
    }

};