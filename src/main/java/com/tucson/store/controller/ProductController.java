package com.tucson.store.controller;

import com.tucson.store.entity.User;
import com.tucson.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.tucson.store.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

  @Autowired
  private ProductService service;


  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @GetMapping("/adminPage")
  public String adminPage() {
    return "404";
  }

  @GetMapping("/userPage")
  @PreAuthorize("hasAuthority('ROLE_USER')")
  public String userPage() {
    return "404";
  }

  @GetMapping("/all")
  public List<Product> getAllTheProducts() {
    return service.getProducts();
  }

  @GetMapping("/{id}")
  public Product getProductById(@PathVariable int id) {
    return service.getProduct(id);
  }

  @PostMapping("/new")
  public String addNewUser(@RequestBody User userInfo){
    return service.addUser(userInfo);
  }
}

