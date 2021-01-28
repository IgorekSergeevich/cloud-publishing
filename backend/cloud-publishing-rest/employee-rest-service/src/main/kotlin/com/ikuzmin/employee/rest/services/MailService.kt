package com.ikuzmin.employee.rest.services

interface MailService {

    fun sendGeneratedPassword(generatedPassword: String)

}