import { axiosInstance } from "./axios-instance";


export const educationsAPI = {
    getEducations() {
        return axiosInstance.get("http://localhost:8080/employee/educations")
            .then(response => response.data);
    }
};