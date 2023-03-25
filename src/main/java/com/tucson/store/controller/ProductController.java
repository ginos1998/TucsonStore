package com.tucson.store.controller;

import com.tucson.store.entity.User;
import com.tucson.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.tucson.store.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService service;

  @GetMapping("/adminPage")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public String adminPage() {
    return "Just admin can read this message.";
  }

  @GetMapping("/userPage")
  @PreAuthorize("hasAuthority('ROLE_USER')")
  public String userPage() {
    return "Just user can read this message.";
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

