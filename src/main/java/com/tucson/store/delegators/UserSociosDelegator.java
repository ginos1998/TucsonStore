package com.tucson.store.delegators;

import com.tucson.store.entity.Socios;
import com.tucson.store.entity.User;
import lombok.Data;

@Data
public class UserSociosDelegator {
  private User user;
  private Socios socios;
  public UserSociosDelegator() {
    user = new User();
    socios = new Socios();
  }
}
