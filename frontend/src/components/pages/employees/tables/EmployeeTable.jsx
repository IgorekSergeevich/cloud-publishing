import React from "react";
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import IconButton from '@material-ui/core/IconButton';
import DeleteIcon from '@material-ui/icons/Delete';
import CreateIcon from '@material-ui/icons/Create';

export const EmployeeTable = ({ employees, isFetching, deleteEmployee }) => {
    return (
        <Table>
            <TableHead>
                <TableRow>
                    <TableCell align="left">#</TableCell>
                    <TableCell align="left">Name</TableCell>
                    <TableCell align="left">Surname</TableCell>
                    <TableCell align="left">Sex</TableCell>
                    <TableCell align="left">Birth date</TableCell>
                    <TableCell align="left">Employee type</TableCell>
                    <TableCell align="left">Actions</TableCell>
                </TableRow>
            </TableHead>
            {isFetching ? (
                <h1>Loading...</h1>
            ) : (
                    <TableBody>
                        {employees.map((e, index) => (
                            <TableRow key={e.id}>
                                <TableCell align="left">{index + 1}</TableCell>
                                <TableCell align="left">{e.firstName}</TableCell>
                                <TableCell align="left">{e.lastName}</TableCell>
                                <TableCell align="left">{e.sex}</TableCell>
                                <TableCell align="left">{e.birthYear}</TableCell>
                                <TableCell align="left">{e.type}</TableCell>
                                <TableCell align="left">
                                    <IconButton>
                                        <CreateIcon />
                                    </IconButton>
                                    <IconButton onClick={() => deleteEmployee(e.id)}>
                                        <DeleteIcon />
                                    </IconButton>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                )}
        </Table>
    );
};