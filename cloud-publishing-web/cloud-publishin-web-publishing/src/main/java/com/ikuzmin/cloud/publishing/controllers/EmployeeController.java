package com.ikuzmin.cloud.publishing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Igor Kuzmin
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

  @GetMapping
  public String index() {
    return "employee-page";
  }

}
