package com.tucson.store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "subrubro")
public class SubRubro {

  @Id
  @Column(name = "id_subrubro")
  private int idSubRubro;
  private String subrubro;
  private Character habilitado;

  @OneToOne
  @JoinColumn(name = "id_rubro", insertable = false)
  private Rubro rubro;

}
