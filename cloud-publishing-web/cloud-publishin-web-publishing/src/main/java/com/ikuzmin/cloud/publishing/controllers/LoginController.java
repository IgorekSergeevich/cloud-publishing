package com.ikuzmin.cloud.publishing.controllers;

import com.ikuzmin.cloud.publishing.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.ikuzmin.cloud.publishing.controllers.IndexController.INDEX_PAGE;

/**
 *
 * @author Igor Kuzmin
 */
@Controller
public class LoginController {

  @Autowired
  private SecurityService securityService;

  @GetMapping("/login")
  public String getLoginPage(@RequestParam(name = "err", required = false) String error) {
    if (securityService.isAuthenticatedRequest()) {
      return "redirect:" + INDEX_PAGE;
    }
    return "login";
  }

}
