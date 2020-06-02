
export function createStore(reducer) {
    let state;
    let callbacks = [];

    function dispatch(action) {
        state = reducer(action, state);
        callbacks.forEach(callback => callback());
    }

    function subscribe(callback) {
        callbacks.push(callback);
        return () => callbacks.filter(cb => cb !== callback);
    }

    function getState() {
        return Object.assign({}, state);
    }

    state = reducer({});
    return {dispatch, subscribe, getState};
}

export function combineReducer(reducerDescriptor) {
    return (action, state = {}) => {
        let nextState = Object.assign({}, state);
        for(let key in reducerDescriptor) {
            if (!state[key]) {
                nextState[key] = reducerDescriptor[key](action);
            } else {
                nextState[key] = reducerDescriptor[key](action, state[key]);
            }
        }
        return nextState;
    };
}