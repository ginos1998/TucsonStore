package com.tucson.store.controller;

import com.tucson.store.entity.User;
import com.tucson.store.service.interfaces.IntUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class AdminPageController {

  @Autowired
  private IntUserService userService;

  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @GetMapping("/adminPage")
  public String adminPage(Model model) {
    var users = userService.listAllUsers();
    model.addAttribute("users", users);
    return "users";
  }

  @GetMapping("/adminPage/deleteUser")
  public String deleteUser(User user) {
    userService.deleteUser(user);
    return "redirect:/adminPage";
  }

  @GetMapping("/adminPage/editUser")
  public String editUser(User user, Model model) {
    user = userService.findUser(user);
    model.addAttribute("user", user);
    return "editUser";
  }

  @PostMapping("/adminPage/saveEditedUser")
  public String saveEditedUser(User user, Errors errors) {
    if (errors.hasErrors()) {
      log.error("Error al guardar usuario.");
      return "users";
    }
    userService.saveUser(user);
    return "redirect:/adminPage";
  }


}
