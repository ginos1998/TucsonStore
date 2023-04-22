package com.tucson.store.config;

import com.tucson.store.repository.FactoryRepository;
import com.tucson.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryConfig {

  @Autowired
  private ProductRepository productRepository;

  public FactoryConfig (){
    // default constructor
  }

  @Bean
  public void setProductRepository() {
    FactoryRepository.setProductRepository(productRepository);
  }
}
