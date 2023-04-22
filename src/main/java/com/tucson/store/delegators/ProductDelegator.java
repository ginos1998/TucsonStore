package com.tucson.store.delegators;

import com.tucson.store.entity.tmp.TmpProduct;
import com.tucson.store.repository.FactoryRepository;

import java.util.List;

public class ProductDelegator {

  private ProductDelegator() {
    // default constructor
  }
  public static List<TmpProduct> fGetEnabledProducts(int idUser){
    return FactoryRepository.getProductRepository().fGetEnabledProducts(idUser);
  }

}
