import * as types from "../actions/action-types";

const initialState = {
    searchList : []
};

export const searchListReducer = (state = initialState, action) => {
    switch (action.type) {
        case types.SEARCH_RESULT_SAVE_ACTION : 
            return Object.assign({}, state, {searchList : action.searchList});
        case types.SEARCH_ITEM_DELETED_ACTION : {
            let searchList = state.searchList.slice();
            searchList.splice(searchList.findIndex(item => item.id === action.itemId), 1);
            return Object.assign({}, state, {searchList : searchList});
        }
        default :
            return state;       
    }
}
