import { TableCell, TableRow } from '@material-ui/core';
import React from 'react'
import CustomerDelete from './CustomerDelete';

const CustomerItem = ({ customer, callAPI }) => {
    const {id, name, image, job, fbirthday, gender, state} = customer;

    return (
        <TableRow>
            <TableCell>{id}</TableCell>
            <TableCell><img src={image} alt='profile' width={50}/></TableCell>
            <TableCell>{name}</TableCell>
            <TableCell>{fbirthday}</TableCell>
            <TableCell>{gender}</TableCell>
            <TableCell>{job}</TableCell>
            <TableCell>
                <CustomerDelete state={state} id={id} callAPI={callAPI}/>
            </TableCell>
        </TableRow>
    )
}

export default CustomerItem