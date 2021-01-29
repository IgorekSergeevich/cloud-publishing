import React from "react";
import { Field } from "redux-form";
import {
  FormControl,
  FormControlLabel,
  FormLabel,
  Radio,
  RadioGroup,
  FormHelperText
} from "@material-ui/core";


const ReduxRadioGroup = (props) => (
  <Field component={FormRadioGroup} {...props} />
);

const FormRadioGroup = ({ formLabel, className, items, meta, input, ...props }) => {
  const hasError = meta.error && meta.touched;

  return (
    <FormControl component="fieldset" className={className} error={hasError}>
      <FormLabel component="legend">{formLabel}</FormLabel>
      <RadioGroup row {...input} {...props}>
        {items?.map((it) => (
          <FormControlLabel
            value={it.value}
            control={<Radio />}
            label={it.label}
            key={it.label}
          />
        ))}
      </RadioGroup>
      {hasError && <FormHelperText>{meta.error}</FormHelperText>}
    </FormControl>);
};

export { ReduxRadioGroup as FormRadioGroup };