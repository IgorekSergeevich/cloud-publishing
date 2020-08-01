import React from "react";
import { keycloak } from "../../auth/keycloak";

class Employees extends React.Component {

    componentDidMount() {
        console.log(keycloak.tokenParsed);
        fetch("http://localhost:8080/users", {
            headers: {
              'Authorization': 'Bearer ' + keycloak.token
            }
        }).then(r => r.json()).then(console.log);

    }

    render() {
        return <h1>Employees</h1>;
    }

}

export { Employees };