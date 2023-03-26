package com.tucson.store.controller;

import com.tucson.store.entity.User;
import com.tucson.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {

  @Autowired
  private ProductService service;

  @GetMapping("/register")
  public String register(User user) {
    return "register";
  }

  @PostMapping("/registerUser")
  public String registerUser(User user) {
    service.addUser(user);
    return "redirect:/login";
  }
}
