package com.tucson.store.controller;

import com.tucson.store.entity.User;
import com.tucson.store.entity.tmp.TmpProduct;
import com.tucson.store.repository.FactoryRepository;
import com.tucson.store.utils.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class ProductController {
  private User currentUser;

  @GetMapping("/productsPage")
  public String productsPage(Model model) {
    currentUser = UserSession.getCurrentUser();
    List<TmpProduct> listProducts = FactoryRepository.getProductRepository().fGetEnabledProducts(currentUser.getIdUser());
    model.addAttribute("products", listProducts);
    return "products";
  }

}
