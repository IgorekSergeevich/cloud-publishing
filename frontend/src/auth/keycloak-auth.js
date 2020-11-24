import Keycloak from "keycloak-js";
import keycloakOptions from "./keycloak.json";
import store from "../redux/store";
import { loginAction } from "../redux/ducks/auth.ts";

export const keycloak = Keycloak(keycloakOptions);

export const checkAuth = async() => {
    const isAuthorized = await keycloak.init({ onLoad: "check-sso", promiseType: "native" });
    if (isAuthorized) {
        store.dispatch(loginAction(keycloak.idTokenParsed.name));
    }
}