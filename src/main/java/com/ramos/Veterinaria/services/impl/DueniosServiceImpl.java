package com.ramos.Veterinaria.services.impl;

import com.ramos.Veterinaria.entities.Duenios;
import com.ramos.Veterinaria.persistence.IDueniosDAO;
import com.ramos.Veterinaria.services.IDueniosService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DueniosServiceImpl implements IDueniosService {

    @Autowired
    private IDueniosDAO dueniosDAO;

    @Override
    public List<Duenios> findAll() {
        return dueniosDAO.findAll();
    }

    @Override
    public Optional<Duenios> findById(Long id) {
        return dueniosDAO.findById(id);
    }

    @Override
    public void save(Duenios duenios) {
        dueniosDAO.save(duenios);
    }

    @Override
    public void deleteById(Long id) {
        dueniosDAO.deleteById(id);
    }
}
