package com.tucson.store.entity.tmp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tmp_product")
public class TmpProduct {
  @Id
  @Column(name = "id_producto")
  private int idProduct;
  private String producto;
  private String marca;
  private String rubro;
  private String subrubro;
  private double precio;
  @Column(name = "ctd_disponible")
  private int ctdDisponible;
  private String descripcion;
}
