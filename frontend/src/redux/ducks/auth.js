import {keycloak} from "../../auth/keycloak-auth"
import {employeeAPI} from "../../api/employee-api"

const LOGIN_USER = "cloud-publishing/auth/LOGIN_USER";
const LOGOUT_USER = "cloud-publishing/auth/LOGOUT_USER";

let initState = {
    userName: null,
    photoUrl: null,
    isAuthorized: false
};

export default (state = initState, action) => {
    switch (action.type) {
        case LOGIN_USER:
            return { ...state, ...action.data };
        case LOGOUT_USER:
            return { ...state, ...initState };
        default:
            return state;
    }
}


export function loginAction(idTokenParsed, shortProfile) {
    return {
        type: LOGIN_USER,
        data: {
            userName: idTokenParsed.name,
            photoUrl: shortProfile.profilePhotoUrl,
            isAuthorized: true
        }
    };
}

export function logoutAction() {
    return {
        type: LOGOUT_USER,
    };
}

export const login = () => async (dispatch) => {
    const isAuthorized = await keycloak.init({ onLoad: "check-sso", promiseType: "native" });
    if (isAuthorized) {
        const shortProfile = await employeeAPI.loadShortProfile();
        dispatch(loginAction(keycloak.idTokenParsed, shortProfile));
    }
};