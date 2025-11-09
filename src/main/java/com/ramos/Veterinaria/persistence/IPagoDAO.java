package com.ramos.Veterinaria.persistence;

import com.ramos.Veterinaria.entities.Pago;

import java.util.List;
import java.util.Optional;

public interface IPagoDAO {

    List<Pago> findAll();

    Optional<Pago> findById(Long idPago);

    void save(Pago pago);

    void deleteById(Long idPago);
}
