package com.ikuzmin.cloud.publishin.web.publishing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Igor Kuzmin
 */

@Controller
@RequestMapping("/main")
public class MainController {
  
  @GetMapping
  public String getLoginPage() {
    return "main";
  }
  
}
