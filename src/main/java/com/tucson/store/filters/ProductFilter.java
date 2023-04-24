package com.tucson.store.filters;

import lombok.Data;

@Data
public class ProductFilter {
  private int idUser;
  private Character enabled;

  public ProductFilter(int idUser, Character enabled) {
    this.idUser = idUser;
    this.enabled = enabled;
  }
}
