package com.ramos.Veterinaria.persistence;

import com.ramos.Veterinaria.entities.Mascota;

import java.util.List;
import java.util.Optional;

public interface IMascotaDAO {

    List<Mascota> findAll();

    Optional<Mascota> findById(Long idMascota);

    void save(Mascota mascota);

    void deleteById(Long idMascota);
}
