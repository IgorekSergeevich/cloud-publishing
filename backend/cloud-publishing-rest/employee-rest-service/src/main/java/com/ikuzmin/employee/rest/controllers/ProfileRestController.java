package com.ikuzmin.employee.rest.controllers;

import java.io.IOException;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletContextResource;

/**
 *
 * @author Igor Kuzmin
 */
@RestController
@RequestMapping("/profile")
public class ProfileRestController {
  
  @Autowired
  private ServletContext servletContext;
  
  @ResponseBody
  @RequestMapping(value = "/avatars/{id}", method = RequestMethod.GET)
  public ResponseEntity<byte[]> getEmployeeAvatar(@PathVariable Integer id) throws IOException {
    Resource result = new ServletContextResource(servletContext, "/WEB-INF/images/image-example.jpg");
    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
            .body(result.getInputStream().readAllBytes());
  }

}
