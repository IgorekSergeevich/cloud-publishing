import Keycloak from "keycloak-js";
import keycloakOptions from "./keycloak.json";

export const keycloak = Keycloak(keycloakOptions);