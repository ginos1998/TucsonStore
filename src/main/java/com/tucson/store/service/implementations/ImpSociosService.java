package com.tucson.store.service.implementations;

import com.tucson.store.entity.Socios;
import com.tucson.store.repository.SociosRepository;
import com.tucson.store.service.interfaces.IntSociosServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImpSociosService implements IntSociosServive {

  @Autowired
  private SociosRepository sociosRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Socios> listAllSocios() {
    return sociosRepository.findAll();
  }

  @Override
  @Transactional
  public void saveSocio(Socios socio) {
    sociosRepository.save(socio);
  }

  @Override
  @Transactional
  public void deleteSocio(Socios socio) {
    sociosRepository.delete(socio);
  }

  @Override
  @Transactional(readOnly = true)
  public Socios findSocio(Socios socio) {
    return sociosRepository.findById(socio.getIdSocio()).orElse(null);
  }
}
