package com.tucson.store.repository;

import com.tucson.store.entity.tmp.TmpUserSocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserSocioRepository extends JpaRepository<TmpUserSocio, Integer> {
  @Query(value = "CALL f_get_enabled_socio()", nativeQuery = true)
  List<TmpUserSocio> fGetEnabledSocio();

}
