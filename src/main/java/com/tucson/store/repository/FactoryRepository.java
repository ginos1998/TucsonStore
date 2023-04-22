package com.tucson.store.repository;


public class FactoryRepository {

  private static ProductRepository productRepository;

  private FactoryRepository(){}

  public static void setProductRepository(ProductRepository productRepository) {
    FactoryRepository.productRepository = productRepository;
  }
  public static ProductRepository getProductRepository() {
    return productRepository;
  }

}
