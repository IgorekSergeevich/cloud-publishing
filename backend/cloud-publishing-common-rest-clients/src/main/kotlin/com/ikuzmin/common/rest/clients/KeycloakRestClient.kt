package com.ikuzmin.common.rest.clients

import com.ikuzmin.cloud.publishing.model.entities.KeycloakUser

class KeycloakRestClient: AbstractRestClient() {

    private lateinit var createEmployeeAccountUrl: String

    private lateinit var getUsersUrl: String

    override fun setServiceUrls() {
        createEmployeeAccountUrl = "${url}/users"
        getUsersUrl = "${url}/users"
    }

    fun createEmployeeAccount(keycloakUser: KeycloakUser) {
        restTemplate?.postForEntity(createEmployeeAccountUrl, keycloakUser, String::class.java)
    }

    fun getUsers() =
        restTemplate?.getForEntity(getUsersUrl, Array<KeycloakUser>::class.java)

}