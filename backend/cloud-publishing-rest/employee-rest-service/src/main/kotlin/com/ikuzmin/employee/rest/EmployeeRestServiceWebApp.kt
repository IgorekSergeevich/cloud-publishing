package com.ikuzmin.employee.rest

import com.ikuzmin.cloud.publishing.model.entities.Profile
import com.ikuzmin.common.rest.clients.RestClientsContext
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling


@SpringBootApplication
@EntityScan(basePackageClasses = [Profile::class])
@Import(RestClientsContext::class)
@EnableScheduling
@EnableAsync
class EmployeeRestServiceWebApp;

fun main(args: Array<String>) {
    runApplication<EmployeeRestServiceWebApp>(*args)
}