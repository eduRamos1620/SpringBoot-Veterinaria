package com.ramos.Veterinaria.repository;

import com.ramos.Veterinaria.entities.Pago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends CrudRepository<Pago, Long> {
}
