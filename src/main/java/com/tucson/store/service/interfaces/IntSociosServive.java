package com.tucson.store.service.interfaces;

import com.tucson.store.entity.Socios;

import java.util.List;

public interface IntSociosServive {
  // CRUD
  List<Socios> listAllSocios();
  void saveSocio(Socios socio);
  void deleteSocio(Socios socio);
  Socios findSocio(Socios socio);
}
