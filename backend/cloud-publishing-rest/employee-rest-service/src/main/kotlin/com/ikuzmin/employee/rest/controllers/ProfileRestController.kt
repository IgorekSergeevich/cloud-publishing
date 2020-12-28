package com.ikuzmin.employee.rest.controllers

import org.springframework.http.MediaType.IMAGE_JPEG
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.support.ServletContextResource
import javax.servlet.ServletContext


@RestController
@RequestMapping("/profile")
class ProfileRestController(
    private val servletContext: ServletContext
) {

    @ResponseBody
    @GetMapping("/avatars/{id}")
    fun getEmployeeAvatar(@PathVariable id: Int): ResponseEntity<ByteArray> {
        val result = ServletContextResource(servletContext, "/WEB-INF/images/image-example.jpg")
        return ResponseEntity.ok().contentType(IMAGE_JPEG).body(result.inputStream.readAllBytes())
    }

}