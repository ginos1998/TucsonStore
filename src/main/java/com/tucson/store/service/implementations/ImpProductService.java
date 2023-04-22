package com.tucson.store.service.implementations;

import com.tucson.store.entity.Product;
import com.tucson.store.entity.tmp.TmpProduct;
import com.tucson.store.repository.ProductRepository;
import com.tucson.store.service.interfaces.IntProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpProductService implements IntProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<TmpProduct> fGetEnabledProducts(int idUser) {
    return productRepository.fGetEnabledProducts(idUser);
  }
}
