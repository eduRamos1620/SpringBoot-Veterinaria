package com.ramos.Veterinaria.services;

import com.ramos.Veterinaria.entities.Cita;

import java.util.List;
import java.util.Optional;

public interface ICitaService {

    List<Cita> findAll();

    Optional<Cita> findById(Long idCita);

    void save(Cita cita);

    void deleteById(Long idCita);
}
