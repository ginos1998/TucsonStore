package com.tucson.store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "producto")
@Data
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_producto")
  private int idProduct;
  private String producto;
  @Column(name = "id_marca")
  private int idMarca;
  @Column(name = "id_rubro")
  private int idRubro;
  @Column(name = "id_subrubro")
  private int idSubrubro;
  private double precio;
  @Column(name = "ctd_diponible")
  private int ctdDisponible;
  @Column(name = "id_user")
  private int idUser;
  private Character habilitado;

  @OneToOne
  @JoinColumn(name = "id_user", nullable = false)
  private User user;

}
