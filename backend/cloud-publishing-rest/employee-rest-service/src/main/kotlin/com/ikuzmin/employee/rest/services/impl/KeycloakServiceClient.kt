package com.ikuzmin.employee.rest.services.impl

import com.ikuzmin.cloud.publishing.model.dto.ProfileDto
import com.ikuzmin.employee.rest.services.MailService
import com.ikuzmin.employee.rest.services.PasswordGeneratorService
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder
import org.jboss.resteasy.util.HttpResponseCodes
import org.keycloak.KeycloakPrincipal
import org.keycloak.admin.client.CreatedResponseUtil
import org.keycloak.admin.client.KeycloakBuilder
import org.keycloak.representations.idm.UserRepresentation
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.keycloak.representations.idm.CredentialRepresentation


@Service
class KeycloakServiceClient(
    private val securityService: SecurityService,
    private val passwordGenerator: PasswordGeneratorService,
    private val mailService: MailService
) {

    @Value("\${keycloak.realm}")
    lateinit var realm: String

    @Value("\${keycloak.auth-server-url}")
    lateinit var serverUrl: String

    fun createUser(profile: ProfileDto) {
        val userResource = buildKeycloakClient()
            .realm(realm)
            .users()
        val userRepresentation = UserRepresentation()
        userRepresentation.isEnabled = true
        userRepresentation.username = profile.username
        userRepresentation.firstName = profile.firstName
        userRepresentation.lastName = profile.lastName
        userRepresentation.email = profile.email

        val response = userResource.create(userRepresentation)
        if (response.status == HttpResponseCodes.SC_CREATED) {
            val userId = CreatedResponseUtil.getCreatedId(response)
            val passwordCred = createPasswordCredentialRepresentation()
            userResource.get(userId).resetPassword(passwordCred)
            mailService.sendGeneratedPassword(passwordCred.value)
        }
    }

    private fun createPasswordCredentialRepresentation(): CredentialRepresentation {
        val passwordCred = CredentialRepresentation()
        passwordCred.isTemporary = true
        passwordCred.type = CredentialRepresentation.PASSWORD
        passwordCred.value = passwordGenerator.generatePassword()
        return passwordCred
    }

    private fun buildKeycloakClient() =
        KeycloakBuilder.builder()
        .serverUrl(serverUrl)
        .realm(realm)
        .authorization(getPrincipalToken())
        .resteasyClient(ResteasyClientBuilder().connectionPoolSize(10).build())
        .build()

    private fun getPrincipalToken() =
        (securityService.getPrincipal() as KeycloakPrincipal<*>)
            .keycloakSecurityContext
            .tokenString
}