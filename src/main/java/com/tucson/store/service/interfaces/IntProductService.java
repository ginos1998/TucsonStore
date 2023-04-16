package com.tucson.store.service.interfaces;

import com.tucson.store.entity.Product;

import java.util.List;

public interface IntProductService {
  List<Product> fGetEnabledProducts(int idUser);
}
