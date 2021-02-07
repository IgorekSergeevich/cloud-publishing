package com.ikuzmin.employee.rest.services.impl

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class SecurityService {

    fun getPrincipal() =
        SecurityContextHolder.getContext().authentication.principal

}