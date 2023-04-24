package com.tucson.store.service;

import com.tucson.store.service.interfaces.IntProductService;

public class ServiceFactory {
  private static IntProductService intProductService;

  private ServiceFactory() {
    // default
  }

  public static void setIntProductService(IntProductService intProductService) {
    ServiceFactory.intProductService = intProductService;
  }

  public static IntProductService getIntProductService() {
    return intProductService;
  }
}
