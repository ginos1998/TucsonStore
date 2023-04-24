package com.tucson.store.repository;


import com.tucson.store.repository.interfaces.IntProductRepository;

public class RepositoryFactory {

  private static TmpProductRepository tmpProductRepository;
  private static IntProductRepository intProductRepository;

  private RepositoryFactory(){}

  public static void setProductRepository(TmpProductRepository tmpProductRepository) {
    RepositoryFactory.tmpProductRepository = tmpProductRepository;
  }
  public static TmpProductRepository getProductRepository() {
    return tmpProductRepository;
  }

  public static void setIntProductRepository(IntProductRepository intProductRepository) {
    RepositoryFactory.intProductRepository = intProductRepository;
  }

  public static IntProductRepository getIntProductRepository() {
    return intProductRepository;
  }

}
