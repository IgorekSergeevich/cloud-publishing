import React from "react";
import { withRouter } from "react-router-dom";
import auth0 from "auth0-js";

const { Consumer, Provider } = React.createContext({ isAuthorise: false });

class AuthProvider extends React.Component {

    constructor(props) {
        super(props);
        this.state = { isAuthorise: false };
        this.auth = new auth0.WebAuth({
            domain: "cloud-publishing.eu.auth0.com",
            clientID: "xvRmaAbIN2J61ACdCCKXrR8GCz5vaqXz",
            redirectUri: "http://localhost:9000/callback",
            scope: "openid",
            responseType: "token id_token"
        });
    }

    authorize() {
        this.auth.authorize();
    }

    handelCallback() {
        this.auth.parseHash((err, result) => {
            if (result && result.accessToken) {
                console.log(accessToken);
                this.setState({ isAuthorise: true });
                this.props.histary.push("/private");
            } else {
                console.log(result);
                console.log(err);
            }
        });
    }

    render() {
        return (
            <Provider value={{
                    isAuthorise: this.state.isAuthorise,
                    authorize: () => this.authorize(),
                    handelCallback: () => this.handelCallback()
                }
            }>
                {this.props.children}
            </Provider>
        );
    }
}
const AuthProviderWithRouter = withRouter(AuthProvider);

export { AuthProviderWithRouter as AuthProvider };

export function withAuthorize(Component) {
    return class ComponentWithAuth extends React.Component {
        render() {
            return (
                <Consumer>
                    {value => <Component {...value} {...this.props} />}
                </Consumer>
            );
        }
    };
}