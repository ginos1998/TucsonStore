package com.tucson.store.service.implementations;

import com.tucson.store.entity.Marca;
import com.tucson.store.entity.Product;
import com.tucson.store.entity.Rubro;
import com.tucson.store.entity.tmp.TmpProduct;
import com.tucson.store.filters.BrandFilter;
import com.tucson.store.filters.IndustryFilter;
import com.tucson.store.filters.ProductFilter;
import com.tucson.store.repository.PersistentFactory;
import com.tucson.store.repository.RepositoryFactory;
import com.tucson.store.service.interfaces.IntProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpProductService implements IntProductService {

  @Override
  public List<TmpProduct> getProductsWithFilter(ProductFilter filter) {
    return RepositoryFactory.getIntProductRepository().getProductsWithFilter(filter);
  }

  @Override
  public void deleteProduct(int idProduct) {
    PersistentFactory.getIntPersistentProduct().deleteById(idProduct);
  }

  @Override
  public void saveProduct(Product product) {
    PersistentFactory.getIntPersistentProduct().save(product);
  }
  @Override
  public List<Marca> getBrandsWithFilter(BrandFilter brandFilter) {
    return RepositoryFactory.getIntProductRepository().getBrandsWithFilter(brandFilter);
  }

  @Override
  public List<Rubro> getIndustriesWithFilter(IndustryFilter industryFilter) {
    return RepositoryFactory.getIntProductRepository().getIndustriesWithWilter(industryFilter);
  }

}
