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

  /**
   * @OneToOne un Socio debe estar relacionado con un User.
   * @JoinColumn indica que la columna "id_user" de la tabla "socio" es la fk
   *             que se relaciona con la primary key "id_user" de la tabla "user".
   */
  @OneToOne
  @JoinColumn(name = "id_user", nullable = false)
  private User user;

}
