package com.tucson.store.delegators;

import com.tucson.store.entity.Marca;
import com.tucson.store.entity.Product;
import com.tucson.store.entity.Rubro;
import com.tucson.store.entity.tmp.TmpProduct;
import com.tucson.store.filters.BrandFilter;
import com.tucson.store.filters.IndustryFilter;
import com.tucson.store.filters.ProductFilter;
import com.tucson.store.repository.PersistentFactory;
import com.tucson.store.repository.RepositoryFactory;
import com.tucson.store.service.ServiceFactory;

import java.util.List;

public class ProductDelegator {

  private ProductDelegator() {
    // default constructor
  }
  public static List<TmpProduct> fGetEnabledProducts(int idUser){
    return RepositoryFactory.getProductRepository().fGetEnabledProducts(idUser);
  }

  public static void deleteProduct(int idProduct) {
    ServiceFactory.getIntProductService().deleteProduct(idProduct);
  }

  public static void saveProduct(Product product) {
    ServiceFactory.getIntProductService().saveProduct(product);
  }

  public static List<TmpProduct> getProductsWithFilter(ProductFilter filter) {
    return ServiceFactory.getIntProductService().getProductsWithFilter(filter);
  }

  public static List<Marca> getBrandsWithFilter(BrandFilter brandFilter) {
    return ServiceFactory.getIntProductService().getBrandsWithFilter(brandFilter);
  }

  public static List<Rubro> getIndustriesWithFilter(IndustryFilter industryFilter) {
    return ServiceFactory.getIntProductService().getIndustriesWithFilter(industryFilter);
  }
}
