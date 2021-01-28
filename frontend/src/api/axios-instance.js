import axios from "axios";
import { keycloak } from "../auth/keycloak-auth";

export const axiosInstance = axios.create();

axiosInstance.interceptors.request.use(
    config => {
        const token = keycloak.token;
        if (token) {
            config.headers['Authorization'] = 'Bearer ' + token;
        }
        return config;
    },
    error => {
        Promise.reject(error)
    });

axiosInstance.interceptors.response.use(
    response => response,
    async error => {
        const originalRequest = error.config;

        if (error.response.status === 401) {
            if (keycloak.authenticated && keycloak.isTokenExpired()) {
                let isRefreshed = await keycloak.updateToken();
                if (isRefreshed) {
                    return axiosInstance(originalRequest);
                }
            } else {
               
            }

        }

        if (error.response.status === 401 && keycloak.isTokenExpired()) {
            let isRefreshed = await keycloak.updateToken();
            if (isRefreshed) {
                return axiosInstance(originalRequest);
            }
        }

        if (error.response.status === 401 && !keycloak.authenticated) {
            console.log("not authorized");
        }

        return Promise.reject(error);
    });