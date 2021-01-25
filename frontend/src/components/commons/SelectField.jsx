import { FormControl, InputLabel, MenuItem, Select } from "@material-ui/core";
import React from "react";
import { Field } from "redux-form";

const SelectField = ({ input, meta, children, ...props }) => (
    <Select {...input} {...props}>
        {children}
    </Select>
);

const ReduxSelect= (props) => <Field component={SelectField} {...props} />;

export const FormSelect = ({ className, name, label, items }) => (
    <FormControl
        variant="outlined"
        className={className}
    >
        <InputLabel>{label}</InputLabel>
        <ReduxSelect
            name={name}
            label={label}
        >
            <MenuItem value="">
                <em>None</em>
            </MenuItem>
            {items?.map((it) => (
                <MenuItem value={it.value} key={it.label}>{it.label}</MenuItem>
            ))}
        </ReduxSelect>
    </FormControl>
);