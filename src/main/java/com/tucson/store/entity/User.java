package com.tucson.store.entity;

import com.tucson.store.utils.Constants;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_user")
  private int idUser;
  private String username;
  private String email;
  private String password;
  @Column(insertable = false) // when user register, this field is null so to prevent exception I use this label
  private String roles;       // so in this way, mySql insert the default value
  @Column(name = "account_non_expired", insertable = false)
  private Character accountNonExpired;
  @Column(name = "account_non_locked", insertable = false)
  private Character accountNonLocked;
  @Column(name = "credentials_non_expired", insertable = false)
  private Character credentialsNonExpired;
  @Column(name = "enabled", insertable = false)
  private Character enabled;

  // boolean methods needed
  public boolean isAccountNonExpiredBoolean() {
    return accountNonExpired.equals(Constants.CHAR_S);
  }

  public boolean isAccountNonLockedBoolean() {
    return accountNonLocked.equals(Constants.CHAR_S);
  }

  public boolean isCredentialsNonExpiredBoolean () {
    return credentialsNonExpired.equals(Constants.CHAR_S);
  }

  public boolean isEnabledBoolean() {
    return enabled.equals(Constants.CHAR_S);
  }
}
