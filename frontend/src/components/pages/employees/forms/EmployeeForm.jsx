import React from "react";
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Radio from '@material-ui/core/Radio';
import Button from '@material-ui/core/Button';
import { makeStyles } from '@material-ui/core/styles';
import { reduxForm, Field } from 'redux-form';


const useStyles = makeStyles((them) => ({
    textField: {
        width: "100%",
        margin: them.spacing(2)
    }
}));

const NewEmployeeForm = ({ handleSubmit }) => {
    const cl = useStyles();
    return (
        <form onSubmit={handleSubmit} method="POST">
            <Grid container spacing={8}>
                <Grid item xs={6}>
                    <Field component={MuiTextField}
                        name="username"
                        label="Login"
                        variant="outlined"
                        className={cl.textField} />

                    <Field component={MuiTextField}
                        name="firstName"
                        label="Firstname"
                        variant="outlined"
                        className={cl.textField} />

                    <Field component={MuiTextField}
                        name="lastName"
                        label="Lastname"
                        variant="outlined"
                        className={cl.textField} />

                    <Field component={MuiTextField}
                        name="email"
                        label="Email"
                        variant="outlined"
                        className={cl.textField} />

                </Grid>
                <Grid itemxs={6}>
                    <FormControl component="fieldset" className={cl.textField}>
                        <FormLabel component="legend">Gender</FormLabel>

                        <RadioGroup row aria-label="gender" name="gender1">
                            <FormControlLabel
                                value="female"
                                control={<Radio />}
                                label="Female"
                            />
                            <FormControlLabel value="male" control={<Radio />} label="Male" />
                            <FormControlLabel
                                value="other"
                                control={<Radio />}
                                label="Other"
                            />
                        </RadioGroup>
                    </FormControl>
                    <Button variant="contained" color="primary" type="submit">
                        Submit
                    </Button>
                </Grid>
            </Grid>
        </form>
    );
};

export const ReduxNewEmployeeForm = reduxForm({
    form: "employeeForm"
})(NewEmployeeForm);

export { ReduxNewEmployeeForm as NewEmployeeForm };

const MuiTextField = ({
    label,
    input,
    meta: { touched, invalid, error },
    ...custom
}) => (
    <TextField
        label={label}
        error={touched && invalid}
        {...input}
        {...custom}
    />
);