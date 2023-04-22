package com.tucson.store.controller;

import com.tucson.store.entity.User;
import com.tucson.store.entity.tmp.TmpUserSocio;
import com.tucson.store.repository.DataRepository;
import com.tucson.store.repository.UserSocioRepository;
import com.tucson.store.service.interfaces.IntSociosServive;
import com.tucson.store.service.interfaces.IntUserService;
import com.tucson.store.service.interfaces.IntUserSocioService;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class AdminPageController {

  @Autowired
  private IntUserService userService;
  @Autowired
  private IntSociosServive sociosServive;
  @Autowired
  private DataRepository dataRepository;
  @Autowired
  private IntUserSocioService userSocioService;

  @Autowired
  private DataSource dataSource;

  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @GetMapping("/adminPage")
  public String adminPage(Model model) {
    List<TmpUserSocio> enabledSocios = userSocioService.fGetEnabledSocio();
    model.addAttribute("enabledSocios", enabledSocios);
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
