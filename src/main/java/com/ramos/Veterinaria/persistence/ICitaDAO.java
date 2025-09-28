package com.ramos.Veterinaria.persistence;

import com.ramos.Veterinaria.entities.Cita;

import java.util.List;
import java.util.Optional;

public interface ICitaDAO {

    List<Cita> findAll();

    Optional<Cita> findById(Long id);

    void save(Cita cita);

    void deleteById(Long id);
}
