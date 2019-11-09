package com.ikuzmin.cloud.publishing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Igor Kuzmin
 */
@Controller
public class LoginController {

  @GetMapping("/login")
  public ModelAndView getLoginPage(@RequestParam(name = "err", required = false) String error) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");
    return modelAndView;
  }

}
