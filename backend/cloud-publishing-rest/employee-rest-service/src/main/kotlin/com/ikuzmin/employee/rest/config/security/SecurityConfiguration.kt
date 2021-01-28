package com.ikuzmin.employee.rest.config.security

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver
import org.keycloak.adapters.springsecurity.KeycloakConfiguration
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy
import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory
import org.passay.PasswordGenerator
import org.passay.CharacterRule

import org.passay.EnglishCharacterData





@KeycloakConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfiguration: KeycloakWebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var keycloakClientRequestFactory: KeycloakClientRequestFactory

    @Bean
    fun keycloakRestTemplate()
        = KeycloakRestTemplate(keycloakClientRequestFactory)

    @Bean
    override fun sessionAuthenticationStrategy() = NullAuthenticatedSessionStrategy()

    @Bean
    fun keycloakConfigResolver() = KeycloakSpringBootConfigResolver()

    @Autowired
    override fun configure(auth: AuthenticationManagerBuilder) {
        val keycloakAuthenticationProvider = keycloakAuthenticationProvider()
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(SimpleAuthorityMapper())
        auth.authenticationProvider(keycloakAuthenticationProvider)
    }

    override fun configure(http: HttpSecurity) {
        super.configure(http)
        http.cors().and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/profile/avatars/*")
            .permitAll()
            .anyRequest()
            .authenticated()
    }

    @Bean
    fun passwordGenerator() = PasswordGenerator()

}
