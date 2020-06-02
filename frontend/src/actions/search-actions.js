import * as types from "./action-types";


export function searchUserAction() {
    return {
        type : types.SEARCH_ACTION,
        searchType : "User list"
    };
}

export function searchWidgetAction() {
    return {
        type : types.SEARCH_ACTION,
        searchType : "Widget list"
    };
}

export function saveSearchResultAction(searchList) {
    return {
        type : types.SEARCH_RESULT_SAVE_ACTION,
        searchList : searchList
    };
}

export function deleteSearchItemAction(id) {
    return {
        type : types.SEARCH_ITEM_DELETED_ACTION,
        itemId : id
    };
}