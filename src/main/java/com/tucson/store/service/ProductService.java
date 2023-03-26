package com.tucson.store.service;

import com.tucson.store.entity.User;
import com.tucson.store.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import com.tucson.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

  List<Product> productList = null;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   * Add a user using, for now, postman
   * @param userInfo User class object to add.
   * @return message.
   */
  public String addUser(User userInfo) {
    userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
    userInfo.setRoles(validateRole(userInfo));
    userRepository.save(userInfo);
    return "user added to system ";
  }

  private String validateRole(User user) {
    return (user.getRoles() == null ? "ROLE_USER" : user.getRoles());
  }

  /**
   * Se generan 100 productos con valores aleatorios.
   */
  @PostConstruct
  public void loadProductsFromDB() {
    productList = IntStream.rangeClosed(1, 100)
        .mapToObj(i -> Product.builder()
            .productId(i)
            .name("product " + i)
            .qty(new Random().nextInt(10))
            .price(new Random().nextInt(5000)).build()
        ).collect(Collectors.toList());
  }

  /**
   * Metodo para obtener los productos
   * @return Product list.
   */
  public List<Product> getProducts() {
    return productList;
  }

  /**
   * Se obtienen los productos por id.
   * @param id product id
   * @return Product.
   */
  public Product getProduct(int id) {
    return productList.stream()
        .filter(product -> product.getProductId() == id)
        .findAny()
        .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
  }
}
