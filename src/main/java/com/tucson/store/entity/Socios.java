package com.tucson.store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "socio")
public class Socios {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_socio")
  private int idSocio;
  private String nombre;
  private String apellido;
  private String dni;
  private String domicilio;

  @ManyToOne
  @JoinColumn(name = "id_user", nullable = false)
  private User user;

}
