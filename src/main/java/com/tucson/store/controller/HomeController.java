package com.tucson.store.controller;

import com.tucson.store.config.UserLoginUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j

public class HomeController {

  @GetMapping({"/", "/index"})
  @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
  public String indexPage(@AuthenticationPrincipal UserLoginUserDetails user) {
    return "index";
  }

  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @GetMapping("/adminPage")
  public String adminPage() {
    return "users";
  }
}
