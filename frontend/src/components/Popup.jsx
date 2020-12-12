import React from "react";
import Dialog from '@material-ui/core/Dialog';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import Typography from '@material-ui/core/Typography';

export const Popup = ({ title, childrens, isOpened }) => {
    return (
        <Dialog open={isOpened} ma>
            <DialogTitle>
                <Typography variant="h6">{title}</Typography>
            </DialogTitle>
            <DialogContent>
                {childrens}
            </DialogContent>
        </Dialog>
    );
};