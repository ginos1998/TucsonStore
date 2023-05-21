package com.tucson.store.filters;

import com.tucson.store.entity.Rubro;
import lombok.Data;

import java.util.List;

@Data
public class IndustryFilter {
  private int idUser;
  private Character enabled;
  private List<Rubro> listRubros;

  public IndustryFilter(int idUser, Character enabled) {
    this.idUser = idUser;
    this.enabled = enabled;
  }

  public IndustryFilter(List<Rubro> listRubros, Character enabled) {
    this.listRubros = listRubros;
    this.enabled = enabled;
  }
}
