package com.tucson.store.repository;

import com.tucson.store.entity.tmp.TmpProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TmpProductRepository extends JpaRepository<TmpProduct, Integer> {

  @Query(value = "CALL f_get_enabled_products(?)", nativeQuery = true)
  List<TmpProduct> fGetEnabledProducts(int idUser);

}
