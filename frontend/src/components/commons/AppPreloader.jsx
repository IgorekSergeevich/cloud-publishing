import React from "react";
import preloader from "../../assets/images/preloader.svg";
import { makeStyles } from '@material-ui/core/styles';

const useStyle = makeStyles({
    preloader: {
        position: "absolute",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "100%",
        width: "100%"
    }
});

export const AppPreloader = () => {
    const cl = useStyle();
    return (
        <div className={cl.preloader}>
            <img src={preloader} alt="Loading" />
        </div>
    );
};