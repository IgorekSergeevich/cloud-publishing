import * as actions from "../../actions/action-types.js";

let initState = {
    name: null,
    isAuthorized: false
};

export const authReducer = (state = initState, action) => {
    switch (action.type) {
        case actions.LOGIN_USER:
            return { ...state, ...action.user };
        case actions.LOGOUT_USER:
            return { ...state, ...initState };
        default:
            return state;    
    }
}