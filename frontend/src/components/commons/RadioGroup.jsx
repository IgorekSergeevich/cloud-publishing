import React from "react";
import { Field } from "redux-form";
import {
  FormControl,
  FormControlLabel,
  FormLabel,
  Radio,
  RadioGroup
} from "@material-ui/core";

const FormRadioGroup = ({ children, input, meta, ...props }) => (
  <RadioGroup {...props} {...input}>
    {children}
  </RadioGroup>
);

const ReduxRadioGroup = (props) => (
  <Field component={FormRadioGroup} {...props} />
);

const FormRadio = ({ formLabel, name, className, items }) => (
  <FormControl component="fieldset" className={className}>
    <FormLabel component="legend">{formLabel}</FormLabel>
    <ReduxRadioGroup row name={name}>
      {items?.map((it) => (
        <FormControlLabel
          value={it.value}
          control={<Radio />}
          label={it.label}
          key={it.label}
        />
      ))}
    </ReduxRadioGroup>
  </FormControl>
);

export { FormRadio as FormRadioGroup };