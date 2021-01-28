package com.ikuzmin.cloud.publishing.model.entities

class KeycloakUser {

    var username: String? = null

    var firstName: String? = null

    var lastName: String? = null

    var email: String? = null

    var enabled: Boolean = true

    var credentials: List<Credential>? = null

    class Credential(val type: String, val value: String)

}