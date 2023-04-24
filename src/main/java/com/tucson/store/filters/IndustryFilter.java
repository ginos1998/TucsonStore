package com.tucson.store.filters;

import lombok.Data;

@Data
public class IndustryFilter {
  private int idUser;
  private Character enabled;

  public IndustryFilter(int idUser, Character enabled) {
    this.idUser = idUser;
    this.enabled = enabled;
  }
}
