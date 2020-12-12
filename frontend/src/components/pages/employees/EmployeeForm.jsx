import React from "react";
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';
import { reduxForm, Field } from 'redux-form';
import Button from '@material-ui/core/Button';

const useStyle = makeStyles({
    root: {

    },
    formTextField: {
        width: "80%",
        marginTop: 20
    }
});

const EmployeeForm = ({ handleSubmit }) => {
    const classes = useStyle();

    return (
        <form onSubmit={handleSubmit} >
            <Grid container>
                <Grid item xs={6}>
                    <Field component={MuiTextField} name="name"
                        label="Name"
                        variant="outlined"
                        classes={{ root: classes.formTextField }} />
                    <Field component={MuiTextField} name="surname"
                        label="Surname"
                        variant="outlined"
                        classes={{ root: classes.formTextField }} />
                </Grid>
            </Grid>
            <Button variant="outlined" size="large" type="submit">Save</Button>
            <Button variant="outlined" size="large" type="reset">Cancel</Button>
        </form>
    );
};

export const ReduxEmployeeForm = reduxForm({
                form: "employeeForm"
})(EmployeeForm);

const MuiTextField = ({
                label,
                input,
                meta: { touched, invalid, error},
    ...custom
}) => (
            <TextField
                label={label}
                error={touched && invalid}
                {...input}
                {...custom}
            />
    );