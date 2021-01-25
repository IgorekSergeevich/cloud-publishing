import React from "react";
import TextField from '@material-ui/core/TextField';
import { Field } from 'redux-form';

const FormTextField = ({ input, meta, ...custom }) => (
    <TextField {...input} {...custom} />
  );
  
  const ReduxFormTextField = (props) => (
    <Field component={FormTextField} {...props} />
  );
  
  export { ReduxFormTextField as FormTextField };