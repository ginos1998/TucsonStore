package com.tucson.store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "marca")
@Data
public class Marca {
  @Id
  @Column(name = "id_marca")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idMarca;
  private String marca;
  private Character habilitada;

  @OneToOne
  @JoinColumn(name = "id_user", nullable = false)
  private User user;
}
