package com.ikuzmin.cloud.publishing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Igor Kuzmin
 */

@Controller
public class IndexController {
  
  public static String INDEX_PAGE = "/employees";
  
  @GetMapping("/")
  public String index() {
    return "redirect:" + INDEX_PAGE;
  }
  
}
