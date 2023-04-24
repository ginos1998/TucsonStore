package com.tucson.store.repository.interfaces;

import com.tucson.store.entity.Marca;
import com.tucson.store.entity.Rubro;
import com.tucson.store.entity.tmp.TmpProduct;
import com.tucson.store.filters.BrandFilter;
import com.tucson.store.filters.IndustryFilter;
import com.tucson.store.filters.ProductFilter;

import java.util.List;

public interface IntProductRepository {
  List<TmpProduct> getProductsWithFilter(ProductFilter filter);
  void deleteProduct(int idProduct);
  List<Marca> getBrandsWithFilter(BrandFilter brandFilter);

  List<Rubro> getIndustriesWithWilter(IndustryFilter industryFilter);
}
