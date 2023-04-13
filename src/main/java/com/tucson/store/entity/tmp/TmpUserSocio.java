package com.tucson.store.entity.tmp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tmp_user_socio")
@Data
public class TmpUserSocio {
  @Id
  private int idUser;
  private String nombre;
  private String apellido;
  private String dni;
  private String email;
}
