package com.tucson.store.filters;

import lombok.Data;

@Data
public class BrandFilter {
  private int idUser;
  private Character enabled;

  public BrandFilter(int idUser, Character enabled) {
    this.idUser = idUser;
    this.enabled = enabled;
  }
}
