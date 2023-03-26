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
  private String roles;
}
