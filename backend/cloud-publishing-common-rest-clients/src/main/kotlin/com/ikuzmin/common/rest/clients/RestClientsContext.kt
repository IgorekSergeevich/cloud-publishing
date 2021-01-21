package com.ikuzmin.common.rest.clients

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.web.client.RestTemplate


@Configuration
@PropertySource("classpath:spring/rest-urls.properties")
open class RestClientsContext {

    @Autowired
    lateinit var restTemplate: RestTemplate

    @Bean
    open fun restClientFactory() = RestClientFactory(restTemplate)

    @Bean
    open fun keycloakRestClient(@Value("\${keycloak-service-url}") url: String)
        = restClientFactory().createRestClient(::KeycloakRestClient, url)

}