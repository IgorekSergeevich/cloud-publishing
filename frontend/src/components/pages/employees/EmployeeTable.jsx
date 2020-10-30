import React from "react";
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

export const EmployeeTable = ({ employees, isLoading }) => {
    return (
        <TableContainer component={Paper}>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell align="right">Name</TableCell>
                        <TableCell align="right">Surname</TableCell>
                        <TableCell align="right">Sex</TableCell>
                        <TableCell align="right">Birth date</TableCell>
                        <TableCell align="right">Employee type</TableCell>
                    </TableRow>
                </TableHead>
                {isLoading ? (
                    <h1>Loading...</h1>
                ) : ( 
                    <TableBody>
                        {employees.map((e) => (
                            <TableRow key={e.id}>
                                <TableCell align="right">{e.name}</TableCell>
                                <TableCell align="right">{e.surname}</TableCell>
                                <TableCell align="right">{e.sex}</TableCell>
                                <TableCell align="right">{e.birthDate}</TableCell>
                                <TableCell align="right">{e.type}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                )}
            </Table>
        </TableContainer>
    );
};