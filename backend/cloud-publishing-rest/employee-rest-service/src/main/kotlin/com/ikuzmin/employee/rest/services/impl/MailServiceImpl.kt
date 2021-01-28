package com.ikuzmin.employee.rest.services.impl

import com.ikuzmin.employee.rest.services.MailService
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component

@Component
class MailServiceImpl(
    private val mailSender: JavaMailSender,
) : MailService {

    override fun sendGeneratedPassword(generatedPassword: String) {
        val message = SimpleMailMessage()
        message.setTo("1216008igorkuzmin@gmail.com")
        message.setSubject("New password created")
        message.setText("Welcome to cloud-publishing! Your password $generatedPassword")
        mailSender.send(message)
    }

}