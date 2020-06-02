import * as types from "../actions/action-types";


export const searchLayoutReducer = (state = {}, action) => {
    switch(action.type) {
        case types.SEARCH_ACTION : 
            return Object.assign({}, state, {searchType : action.searchType});
        default:
            return state;    
    }
}