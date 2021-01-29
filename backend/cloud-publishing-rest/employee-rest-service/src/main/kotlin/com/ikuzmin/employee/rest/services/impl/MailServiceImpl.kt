package com.ikuzmin.employee.rest.services.impl

import com.ikuzmin.employee.rest.services.MailService
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.LinkedBlockingQueue
import javax.mail.SendFailedException

@Component
class MailServiceImpl(
    private val mailSender: JavaMailSender,
) : MailService {

    companion object {
        val messageQueue = LinkedBlockingQueue<SimpleMailMessage>()
    }

    @Async
    @Scheduled(fixedRate = 10000)
    override fun handleMessageQueue() {
        while (!messageQueue.isEmpty()) {
            try {
                mailSender.send(messageQueue.poll())
            } catch (ex: SendFailedException) {

            }
        }
    }

    override fun sendGeneratedPassword(generatedPassword: String) {
        val message = SimpleMailMessage()
        message.setTo("1216008igorkuzmin@gmail.com")
        message.setSubject("New password created")
        message.setText("Welcome to cloud-publishing! Your password $generatedPassword")
        messageQueue.add(message)
    }

}