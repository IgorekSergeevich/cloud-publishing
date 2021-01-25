import React from "react";
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';
import { makeStyles } from '@material-ui/core/styles';
import { reduxForm } from 'redux-form';
import { FormTextField as TextField } from "../../../commons/TextField.jsx";
import { FormRadioGroup as RadioGroup } from "../../../commons/RadioGroup.jsx";
import { FormSelect as Select } from "../../../commons/SelectField.jsx";
import { FormCheckboxGroup as CheckboxGroup } from "../../../commons/CheckboxGroup.jsx";


const sex = [
    {
        label: "Male",
        value: "M"
    },
    {
        label: "Female",
        value: "F"
    },
    {
        label: "Other",
        value: "O"
    }
];

const positions = [
    {
        label: "Redactor",
        value: "Redactor"
    },
    {
        label: "Journalist",
        value: "Journalist"
    }
];

const useStyles = makeStyles((theme) => ({
    formField: {
        width: "100%",
        margin: theme.spacing(1),
    }
}));

const NewEmployeeForm = ({ handleSubmit, educations }) => {
    const cl = useStyles();
    return (
        <form onSubmit={handleSubmit}>
            <Grid container spacing={4}>
                <Grid item xs={6}>
                    <TextField
                        name="username"
                        label="Login"
                        variant="outlined"
                        className={cl.formField} />
                    <TextField
                        name="firstName"
                        label="Firstname"
                        variant="outlined"
                        className={cl.formField} />
                    <TextField
                        name="lastName"
                        label="Lastname"
                        variant="outlined"
                        className={cl.formField} />
                    <TextField
                        name="email"
                        label="Email"
                        variant="outlined"
                        className={cl.formField} />
                    <RadioGroup
                        className={cl.formField}
                        name="sex"
                        formLabel="Gender"
                        items={sex} />
                </Grid>
                <Grid item xs={6}>
                    <Select
                        items={positions}
                        name="type"
                        className={cl.formField}
                        label="Positions"
                    />
                    <TextField
                        name="address"
                        label="Address"
                        variant="outlined"
                        className={cl.formField} />
                    <Select
                        items={educations.map(e => ({
                            label: e.title,
                            value: e.id
                        }))}
                        name="educationId"
                        className={cl.formField}
                        label="Education"
                    />
                    <TextField
                        label="Birthday"
                        type="date"
                        name="birthDate"
                        valuedefault="2017-05-24"
                        className={cl.formField}
                        InputLabelProps={{
                            shrink: true
                        }}
                    />
                    <CheckboxGroup
                        className={cl.formField}
                        items={[
                            {
                                name: "chiefEditor",
                                label: "Chief Editor"
                            }
                        ]}
                    />
                </Grid>
            </Grid>
            <Grid container spacing={3}>
                <Grid item xs={6}>
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