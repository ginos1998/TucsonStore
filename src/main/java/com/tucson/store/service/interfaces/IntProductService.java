package com.tucson.store.service.interfaces;

import com.tucson.store.entity.Marca;
import com.tucson.store.entity.Product;
import com.tucson.store.entity.Rubro;
import com.tucson.store.entity.SubRubro;
import com.tucson.store.entity.tmp.TmpProduct;
import com.tucson.store.filters.BrandFilter;
import com.tucson.store.filters.IndustryFilter;
import com.tucson.store.filters.ProductFilter;

import java.util.List;

public interface IntProductService {
  List<TmpProduct> getProductsWithFilter(ProductFilter productFilter);
  void deleteProduct(int idProduct);
  void saveProduct(Product product);

  List<Marca> getBrandsWithFilter(BrandFilter brandFilter);
  List<Rubro> getIndustriesWithFilter(IndustryFilter industryFilter);

  List<SubRubro> getSubIndustriesWithFilter(IndustryFilter industryFilter);

}
