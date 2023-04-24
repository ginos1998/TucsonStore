package com.tucson.store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "rubro")
public class Rubro {
  @Id
  @Column(name = "id_rubro")
  private int idRubro;
  private String rubro;
  private Character habilitado;

  @OneToOne
  @JoinColumn(name = "id_user", insertable = false)
  private User user;

}
