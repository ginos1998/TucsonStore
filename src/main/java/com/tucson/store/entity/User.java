package com.tucson.store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idUser;
  private String name;
  private String email;
  private String password;
  @Column(insertable = false) // when user register, this field is null so to prevent exception I use this label
  private String roles;       // so in this way, mySql insert the default value
}
