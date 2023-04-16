package com.tucson.store.repository;

import com.tucson.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  @Query(value = "CALL f_get_enabled_products(?)", nativeQuery = true)
  List<Product> fGetEnabledProducts(int idUser);

}
