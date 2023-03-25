package com.tucson.store.controller;

import com.tucson.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tucson.store.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService service;

  @GetMapping("/private")
  public String welcome() {
    return "Just admin or users can read this message.";
  }

  @GetMapping("/all")
  public List<Product> getAllTheProducts() {
    return service.getProducts();
  }

  @GetMapping("/{id}")
  public Product getProductById(@PathVariable int id) {
    return service.getProduct(id);
  }

}

