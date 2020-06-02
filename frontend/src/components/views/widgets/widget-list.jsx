import React from "react";

export function WidgetList(props) {
    return (
        <table>
            <tbody>
                {
                    props.widgetList.map(widget => (
                        <tr key={widget.id}>
                            <td>{widget.name}</td>
                            <td>{widget.model}</td>
                            <td>
                                <button onClick={() => props.deleteWidget(widget.id)}>
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