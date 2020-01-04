package com.ikuzmin.cloud.publishing.controllers;

import com.ikuzmin.cloud.publishing.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Igor Kuzmin
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;
  
  @GetMapping
  public ModelAndView index(ModelAndView modelAndView) {
    modelAndView.addObject("employees", employeeService.getAllEmployee());
    modelAndView.setViewName("employee-page");
    return modelAndView;
  }

}
