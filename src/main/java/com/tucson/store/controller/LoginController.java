package com.tucson.store.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {
  @GetMapping("/login")
  public String loginPage(@AuthenticationPrincipal User user) {
    return "login";
  }
}
