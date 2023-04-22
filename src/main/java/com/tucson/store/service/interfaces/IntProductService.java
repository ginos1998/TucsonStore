package com.tucson.store.service.interfaces;

import com.tucson.store.entity.Product;
import com.tucson.store.entity.tmp.TmpProduct;

import java.util.List;

public interface IntProductService {
  List<TmpProduct> fGetEnabledProducts(int idUser);
}
