package com.ramos.Veterinaria.repository;

import com.ramos.Veterinaria.entities.Duenios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DueniosRepository extends CrudRepository<Duenios, Long> {
}
