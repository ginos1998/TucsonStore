package com.tucson.store.service.implementations;

import com.tucson.store.entity.tmp.TmpUserSocio;
import com.tucson.store.repository.UserSocioRepository;
import com.tucson.store.service.interfaces.IntUserSocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpUserSocioService implements IntUserSocioService {

  @Autowired
  private UserSocioRepository userSocioRepository;

  @Override
  public List<TmpUserSocio> fGetEnabledSocio() {
    return userSocioRepository.fGetEnabledSocio();
  }
}
