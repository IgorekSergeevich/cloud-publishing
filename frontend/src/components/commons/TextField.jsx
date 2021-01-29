import React from "react";
import TextField from '@material-ui/core/TextField';
import { Field } from 'redux-form';

const FormTextField = ({ input, meta, ...custom }) => {
  const hasError = meta.error && meta.touched;
  return <TextField {...input} {...custom} error={hasError} helperText={hasError && meta.error} />
};

const ReduxFormTextField = (props) => (
  <Field component={FormTextField} {...props} />
);

export { ReduxFormTextField as FormTextField };