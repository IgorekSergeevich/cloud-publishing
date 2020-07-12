import * as actions from "./action-types.js";
import { UserPrincipalType } from "../redux/reducers/auth-reducer";

export type AuthUserActionType = {
    type: typeof actions.LOGIN_USER | typeof actions.LOGOUT_USER,
    userPrincipal?: UserPrincipalType
};

export function loginAction(userPrincipal: UserPrincipalType): AuthUserActionType {
    return {
        type: actions.LOGIN_USER,
        userPrincipal: userPrincipal
    };
}

export function logoutAction(): AuthUserActionType {
    return {
        type: actions.LOGOUT_USER,
    };
}
