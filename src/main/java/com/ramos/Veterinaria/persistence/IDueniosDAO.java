package com.ramos.Veterinaria.persistence;

import com.ramos.Veterinaria.entities.Duenios;

import java.util.List;
import java.util.Optional;

public interface IDueniosDAO {

    List<Duenios> findAll();

    Optional<Duenios> findById(Long idDuenio);

    void save(Duenios duenios);

    void deleteById(Long idDuenio);
}
