import React from 'react'
import { CloseButton } from 'react-bootstrap';

const CheckListItem = ({ contentsList, onClickDelete, onToggle }) => {

    const {id, contents, checked} = contentsList;

    return (
        <tr key={id} className={checked ? "checked" : ""} >
            <td style={{ border: "none", width: 10 }}>
                <input
                        type="checkbox"
                        checked={checked}
                        readOnly
                        onClick={() => onToggle(id)} />
            </td>
            <td style={{ border: "none" }}>
                {contents}
            </td>
            <td style={{ border: "none", textAlign: "right" }}>
                <CloseButton
                        className="mx-3"
                        onClick={() => onClickDelete(id)} />
            </td>
        </tr>
    )

}

export default CheckListItem