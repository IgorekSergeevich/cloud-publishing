import Employees from "../../test-data/employees.json";

export function getEmployeeList() {
    return fetch("http://localhost:8080/users")
        .then(response => response.json());
}

/*console.log(keycloak.tokenParsed);
        fetch("http://localhost:8080/users", {
            headers: {
              'Authorization': 'Bearer ' + keycloak.token
            }
        }).then(r => r.json()).then(console.log);*/
export function getEmployeeListMock() {
    return new Promise(resolve => {
        setTimeout(() => resolve(Employees), 1000);
    });
}

export function deleteEmployeeById(id) {
    return fetch(`http://localhost:8080/users/${id}`, { method: "DELETE" })
        .then(() => id);
}

export function deleteEmployeeByIdMock(id) {
    return new Promise(resolve => {
        setTimeout(() => resolve(id), 1000);
    });
}