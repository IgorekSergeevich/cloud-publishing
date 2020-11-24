const LOGIN_USER = "cloud-publishing/auth/LOGIN_USER";
const LOGOUT_USER = "cloud-publishing/auth/LOGOUT_USER";

let initState = {
    userName: null as string | null,
    isAuthorized: false
};

export default (state = initState, action: AuthUserActionType) => {
    switch (action.type) {
        case LOGIN_USER:
            return { ...state, ...{ isAuthorized: true, userName: action.userName } };
        case LOGOUT_USER:
            return { ...state, ...initState }; 
        default:
            return state;
    }
}

export type AuthUserActionType = {
    type: typeof LOGIN_USER | typeof LOGOUT_USER,
    isStartLogin?: string
    userName?: string
};

export function loginAction(userName: string): AuthUserActionType {
    return {
        type: LOGIN_USER,
        userName
    };
}

export function logoutAction(): AuthUserActionType {
    return {
        type: LOGOUT_USER,
    };
}