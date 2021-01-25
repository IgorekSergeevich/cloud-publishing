import { educationsAPI } from "../../api/educations-api";


const LOADING_EDUCATIONS_LIST = "cloud-publishing/educations/LOADING_EDUCATIONS_LIST";
const EDUCATIONS_LIST_LOADED = "cloud-publishing/educations/EDUCATIONS_LIST_LOADED";

const initState = {
    educations: [],
    isFetching: false
};

export default (state = initState, action) => {
    switch (action.type) {
        case LOADING_EDUCATIONS_LIST:
            return { ...state, isFetching: true };
        case EDUCATIONS_LIST_LOADED:
            return { ...state, educations: action.educations, isFetching: false };
        default:
            return state;

    }
};

export const educationsLoadingAction = () => {
    return {
        type: LOADING_EDUCATIONS_LIST
    };
};

export const educationsLoadedAction = (educations) => {
    return {
        type: EDUCATIONS_LIST_LOADED,
        educations
    };
};

export const loadEducations = () => (dispatch) => {
    dispatch(educationsLoadingAction());
    educationsAPI.getEducations().then(e => dispatch(educationsLoadedAction(e)));
};