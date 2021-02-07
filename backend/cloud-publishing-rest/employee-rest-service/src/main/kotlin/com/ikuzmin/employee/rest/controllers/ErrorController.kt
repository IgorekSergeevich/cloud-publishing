package com.ikuzmin.employee.rest.controllers

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class ErrorController : ResponseEntityExceptionHandler() {

    @ExceptionHandler(HttpClientErrorException.Conflict::class)
    fun handleConflict(ex: HttpClientErrorException.Conflict, req: WebRequest): ResponseEntity<Any> =
        handleExceptionInternal(ex, ex.responseBodyAsString, HttpHeaders(), HttpStatus.CONFLICT, req)

}