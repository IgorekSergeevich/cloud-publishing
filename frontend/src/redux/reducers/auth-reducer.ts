import * as actions from "../../actions/action-types.js";
import { AuthUserActionType } from "../../actions/auth-actions";

let initState = {
    userName: null as string | null,
    isAuthorized: false
};

export const authReducer = (state = initState, action: AuthUserActionType) => {
    switch (action.type) {
        case actions.LOGIN_USER:
            return { ...state, ...{ isAuthorized: true, userName: action.userName } };
        case actions.LOGOUT_USER:
            return { ...state, ...initState }; 
        default:
            return state;
    }
}