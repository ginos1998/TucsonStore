package com.tucson.store.controller;

import com.tucson.store.config.UserLoginUserDetails;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j

public class HomeController {

  @GetMapping({"/", "/index"})
  @PreAuthorize("hasAuthority('ROLE_USER')")
  public String indexPage(@AuthenticationPrincipal UserLoginUserDetails user) {
    log.info("usuario logeado: " + user );
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return "index";
  }
}
