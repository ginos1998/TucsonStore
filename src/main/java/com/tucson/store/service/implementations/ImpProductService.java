package com.tucson.store.service.implementations;

import com.tucson.store.entity.Product;
import com.tucson.store.service.interfaces.IntProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpProductService implements IntProductService {

  @Override
  public List<Product> fGetEnabledProducts(int idUser) {
    return null;
  }
}
