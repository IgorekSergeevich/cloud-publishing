import * as actions from "./action-types.js";

export type AuthUserActionType = {
    type: typeof actions.LOGIN_USER | typeof actions.LOGOUT_USER,
    isStartLogin?: string
    userName?: string
};

export function loginAction(userName: string): AuthUserActionType {
    return {
        type: actions.LOGIN_USER,
        userName
    };
}

export function logoutAction(): AuthUserActionType {
    return {
        type: actions.LOGOUT_USER,
    };
}