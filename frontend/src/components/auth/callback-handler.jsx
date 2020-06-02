import React from "react";
import {withAuthorize} from "../auth/auth-provider.jsx";

class Callback extends React.Component {

    componentDidMount() {
        this.props.handelCallback();
    }

    render() {
        return(<p>Loading....</p>);
    }
}

const CallbackWithAuthorise = withAuthorize(Callback);

export {CallbackWithAuthorise as Callback};

