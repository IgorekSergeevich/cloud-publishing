import React from "react";
import { keycloak } from "../auth/keycloak";

export const LoginLayout = props => {
    return (
        <div>
            <header>
                <h1>Login</h1>
                <input type="button"
                    value="Login"
                    onClick={() => keycloak.login()} />
            </header>
            <section>

            </section>
            <footer>

            </footer>
        </div>
    );
};
