import * as actions from "./action-types.js";

export function loginAction(user) {
    return {
        type: actions.LOGIN_USER,
        user: user
    };
}

export function logoutAction() {
    return {
        type: actions.LOGOUT_USER,
    };
}
