package com.ramos.Veterinaria.persistence;

import com.ramos.Veterinaria.entities.Pago;

import java.util.List;
import java.util.Optional;

public interface IPagoDAO {

    List<Pago> findAll();

    Optional<Pago> findById(Long id);

    void save(Pago pago);

    void deleteById(Long id);
}
