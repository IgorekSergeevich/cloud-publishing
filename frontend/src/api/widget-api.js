
export function getWidgetList() {
    return fetch("http://localhost:8080/widgets")
        .then(response => response.json());
}

export function deleteWidgetById(id) {
    return fetch(`http://localhost:8080/widgets/${id}`, {method: "DELETE"})
        .then(() => id);
}