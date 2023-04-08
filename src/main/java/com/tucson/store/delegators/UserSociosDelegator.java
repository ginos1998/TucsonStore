package com.tucson.store.delegators;

import com.tucson.store.entity.Socios;
import com.tucson.store.entity.User;
import lombok.Data;

@Data
public class UserSociosDelegator {
  private User user;
  private String username;
  private String email;
  private String password;
  private Socios socios;
  private String nombre;
  private String apellido;
  private String dni;
  private String domicilio;

  public UserSociosDelegator() {
    // default constructor
  }
}
