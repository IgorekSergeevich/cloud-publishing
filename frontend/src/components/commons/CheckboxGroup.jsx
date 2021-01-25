import { Checkbox, FormControlLabel, FormGroup } from "@material-ui/core";
import React from "react";
import { Field } from "redux-form";

const CheckboxForm = ({ meta, input, ...props }) => (
  <Checkbox {...input} {...props} />
);

const ReduxCheckbox = (props) => <Field component={CheckboxForm} {...props} />;

export const FormCheckboxGroup = ({ items, className }) => (
  <FormGroup row className={className}>
    {items.map((it) => (
      <FormControlLabel
        control={<ReduxCheckbox name={it.name} />}
        label={it.label}
        key={it.name}
      />
    ))}
  </FormGroup>
);