package com.tucson.store.controller;

import com.tucson.store.entity.Product;
import com.tucson.store.service.interfaces.IntProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

  @Autowired
  private IntProductService productService;

  @GetMapping("/productsPage")
  public String productsPage(Model model) {
    List<Product> listProducts = productService.fGetEnabledProducts(1);
    model.addAttribute("products", listProducts);
    return "products";
  }
}
