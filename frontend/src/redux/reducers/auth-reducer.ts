import * as actions from "../../actions/action-types.js";
import { AuthUserActionType } from "../../actions/auth-actions";

export type UserPrincipalType = {
    userName: string
};

let initState = {
    userPrincipal: null as UserPrincipalType | null,
    isAuthorized: false
};

export const authReducer = (state = initState, action: AuthUserActionType) => {
    debugger;
    switch (action.type) {
        case actions.LOGIN_USER:
            return { ...state, ...{ isAuthorized: true, userPrincipal: action.userPrincipal } };
        case actions.LOGOUT_USER:
            return { ...state, ...initState };
        default:
            return state;
    }
}