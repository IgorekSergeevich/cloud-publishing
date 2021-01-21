package com.ikuzmin.employee.rest

import com.ikuzmin.cloud.publishing.model.entities.Profile
import com.ikuzmin.common.rest.clients.RestClientsContext
import org.modelmapper.ModelMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import


@SpringBootApplication
@EntityScan(basePackageClasses = [Profile::class])
@Import(RestClientsContext::class)
class EmployeeRestServiceWebApp {
    @Bean
    fun modelMapper() = ModelMapper()
}

fun main(args: Array<String>) {
    runApplication<EmployeeRestServiceWebApp>(*args)
}