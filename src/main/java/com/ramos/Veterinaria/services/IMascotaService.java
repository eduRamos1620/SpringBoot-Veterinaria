package com.ramos.Veterinaria.services;

import com.ramos.Veterinaria.entities.Mascota;

import java.util.List;
import java.util.Optional;

public interface IMascotaService {

    List<Mascota> findAll();

    Optional<Mascota> findById(Long idMascota);

    void save(Mascota mascota);

    void deleteById(Long idMascota);
}
