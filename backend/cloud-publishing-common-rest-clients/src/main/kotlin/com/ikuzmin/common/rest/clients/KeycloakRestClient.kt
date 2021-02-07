package com.ikuzmin.common.rest.clients

import com.ikuzmin.cloud.publishing.model.entities.KeycloakUser
import org.springframework.http.ResponseEntity
import org.springframework.web.client.postForEntity

class KeycloakRestClient: AbstractRestClient() {

    private lateinit var createEmployeeAccountUrl: String

    private lateinit var getUsersUrl: String

    override fun setServiceUrls() {
        createEmployeeAccountUrl = "${url}/users"
        getUsersUrl = "${url}/users"
    }

    fun createEmployeeAccount(keycloakUser: KeycloakUser): ResponseEntity<Any>? {
        return restTemplate?.postForEntity(createEmployeeAccountUrl, keycloakUser, Any::class)
    }

    fun getUsers() =
        restTemplate?.getForEntity(getUsersUrl, Array<KeycloakUser>::class.java)

}