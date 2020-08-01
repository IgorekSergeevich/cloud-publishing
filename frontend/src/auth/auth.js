import { keycloak } from "./keycloak";
import store from "../redux/store";
import { loginAction } from "../actions/auth-actions.ts";

export const checkAuth = async () => {
    const isAuthorized = await keycloak.init({ onLoad: "check-sso", promiseType: "native" });
    if (isAuthorized) {
        store.dispatch(loginAction(keycloak.idTokenParsed.name));
    }

} 