import { axiosInstance } from "./axios-instance";


export const employeeAPI = {
    
    getEmployeeList() {
        return axiosInstance.get("http://localhost:8080/employee/all")
            .then(response => response.data);
    },
    
    deleteEmployeeByIdMock(id) {
        return new Promise(resolve => {
            setTimeout(() => resolve(id), 1000);
        });
    },

    createEmployeeAccount(employee) {
        return axiosInstance.post(
            "http://localhost:8180/auth/admin/realms/cloud-publishing/users", employee);
    }
};