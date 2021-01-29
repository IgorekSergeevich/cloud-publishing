import { FormControl, InputLabel, MenuItem, Select, FormHelperText } from "@material-ui/core";
import React from "react";
import { Field } from "redux-form";


const FormSelect = ({ className, label, items, meta, input, ...props }) => {
    const hasError = meta.error && meta.touched;
    return (
        <FormControl
            variant="outlined"
            className={className}
            error={hasError}
        >
            <InputLabel>{label}</InputLabel>
            <Select {...input} {...props} label={label}>
                <MenuItem value="">
                    <em>None</em>
                </MenuItem>
                {items?.map((it) => (
                    <MenuItem value={it.value} key={it.label}>{it.label}</MenuItem>
                ))}
            </Select>
            {hasError && <FormHelperText>{meta.error}</FormHelperText>}
        </FormControl>);
};

const ReduxFormSelect = (props) => <Field component={FormSelect} {...props} />;

export { ReduxFormSelect as FormSelect };