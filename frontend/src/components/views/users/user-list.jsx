import React from "react";

export function UserList(props) {

    return (
        <table>
            <tbody>
                {
                    props.userList.map(user => (
                        <tr key={user.id}>
                            <td>{user.name}</td>
                            <td>{user.surname}</td>
                            <td>
                                <button onClick={() => props.deleteUser(user.id)}>
                                    Удалить
                                    </button>
                            </td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    );
}