package com.tucson.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class WelcomeController {

  @GetMapping("/welcome")
  public String welcome() {
    return "Welcome to TucsonStore (not secured)";
  }
}
