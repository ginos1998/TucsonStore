package com.tucson.store.config;

import com.tucson.store.repository.PersistentFactory;
import com.tucson.store.repository.RepositoryFactory;
import com.tucson.store.repository.TmpProductRepository;
import com.tucson.store.repository.interfaces.IntPersistentProduct;
import com.tucson.store.repository.interfaces.IntProductRepository;
import com.tucson.store.service.ServiceFactory;
import com.tucson.store.service.interfaces.IntProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryConfig {

  public FactoryConfig (){
    // default constructor
  }

  //***************************** REPOSITORY FACTORY *****************************//
  @Autowired
  public void setProductRepository(TmpProductRepository tmpProductRepository) {
    RepositoryFactory.setProductRepository(tmpProductRepository);
  }

  @Autowired
  public void setIntMarcaRepository(IntProductRepository intProductRepository) {
    RepositoryFactory.setIntProductRepository(intProductRepository);
  }

  //***************************** SERVICE FACTORY *****************************//

  @Autowired
  public void setIntProductService(IntProductService intProductService) {
    ServiceFactory.setIntProductService(intProductService);
  }

  //***************************** PERSISTENCE FACTORY *****************************//
  @Autowired
  public void setIntPersistentProduct(IntPersistentProduct intPersistentProduct) {
    PersistentFactory.setIntPersistentProduct(intPersistentProduct);
  }

}
