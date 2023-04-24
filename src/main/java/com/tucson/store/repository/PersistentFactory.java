package com.tucson.store.repository;

import com.tucson.store.repository.interfaces.IntPersistentProduct;

public class PersistentFactory {
  private static IntPersistentProduct intPersistentProduct;

  private PersistentFactory() {

  }

  public static void setIntPersistentProduct(IntPersistentProduct intPersistentProduct) {
    PersistentFactory.intPersistentProduct = intPersistentProduct;
  }

  public static IntPersistentProduct getIntPersistentProduct() {
    return PersistentFactory.intPersistentProduct;
  }
}
