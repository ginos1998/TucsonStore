package com.tucson.store.repository;

import com.tucson.store.entity.Socios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SociosRepository extends JpaRepository<Socios, Integer> {
  Optional<Socios> findByDni(String dni);
}
