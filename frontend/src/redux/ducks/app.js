import { login } from "./auth";

const INITIALIZED = "cloud-publishing/app/INITIALIZED";

const initState = {
    isInitialized: false
};

export default (state = initState, action) => {
    switch (action.type) {
        case INITIALIZED:
            return { ...state, isInitialized: action.isInitialized };
        default:
            return state;
    }
};

export const initializedAction = () => ({
    type: INITIALIZED,
    isInitialized: true
});

export const initializeApp = () => async (dispatch) => {
     const isAuthorized = await dispatch(login());
     dispatch(initializedAction());
};