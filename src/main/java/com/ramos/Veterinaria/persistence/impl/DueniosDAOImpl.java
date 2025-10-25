package com.ramos.Veterinaria.persistence.impl;

import com.ramos.Veterinaria.entities.Duenios;
import com.ramos.Veterinaria.persistence.IDueniosDAO;
import com.ramos.Veterinaria.repository.DueniosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DueniosDAOImpl implements IDueniosDAO {

    @Autowired
    private DueniosRepository repository;

    @Override
    public List<Duenios> findAll() {
        return (List<Duenios>) repository.findAll();
    }

    @Override
    public Optional<Duenios> findById(Long idDuenio) {
        return repository.findById(idDuenio);
    }

    @Override
    public void save(Duenios duenios) {
        repository.save(duenios);
    }

    @Override
    public void deleteById(Long idDuenio) {
        repository.deleteById(idDuenio);
    }
}
