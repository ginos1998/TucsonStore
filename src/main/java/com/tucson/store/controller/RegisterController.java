package com.tucson.store.controller;

import com.tucson.store.delegators.UserSociosDelegator;
import com.tucson.store.entity.Socios;
import com.tucson.store.entity.User;
import com.tucson.store.service.interfaces.IntSociosServive;
import com.tucson.store.service.interfaces.IntUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {

  @Autowired
  private IntUserService userService;
  @Autowired
  private IntSociosServive sociosService;

  @GetMapping("/register")
  public String register(Model model) {
    model.addAttribute("usd", new UserSociosDelegator());
    return "register";
  }

  @PostMapping("/registerUser")
  public String registerUser(@ModelAttribute("usd") UserSociosDelegator usd) {
    validateNewUser(usd.getUser());
    validateNewSocio(usd.getSocios(), usd.getUser());
    return "redirect:/login";
  }

  private void validateNewUser(User user) {
    userService.addUser(user);
  }

  private void validateNewSocio(Socios socios, User user) {
    socios.setUser(user);
    sociosService.saveSocio(socios);
  }
}
