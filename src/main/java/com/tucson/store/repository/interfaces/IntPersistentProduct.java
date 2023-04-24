package com.tucson.store.repository.interfaces;

import com.tucson.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntPersistentProduct extends JpaRepository<Product,Integer> {
  @Override
  void deleteById(Integer integer);

}
