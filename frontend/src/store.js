import {createStore, combineReducers} from "redux"; 
import {searchListReducer} from "./reducers/search-list-reducer";
import {searchLayoutReducer} from "./reducers/search-layout-reducer";

const reducerDescriptor = {search : searchListReducer, searchState : searchLayoutReducer};

let reducer = combineReducers(reducerDescriptor);

export default createStore(reducer);
