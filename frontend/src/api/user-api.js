
export function getUserList() {
    return fetch("http://localhost:8080/users")
        .then(response => response.json());
}

export function deleteUserById(id) {
    return fetch(`http://localhost:8080/users/${id}`, {method: "DELETE"})
        .then(() => id);
}
