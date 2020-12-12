import React from "react";
import { ThemeProvider } from '@material-ui/core/styles';
import { CssBaseline } from '@material-ui/core';

export const AppTheme = ({ children }) => (
    <ThemeProvider>
        <CssBaseline />
        {children}
    </ThemeProvider>
);