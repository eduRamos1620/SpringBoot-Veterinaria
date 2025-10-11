package com.ramos.Veterinaria.services.impl;

import com.ramos.Veterinaria.entities.Cita;
import com.ramos.Veterinaria.persistence.ICitaDAO;
import com.ramos.Veterinaria.services.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CitaServiceImpl implements ICitaService {

    @Autowired
    private ICitaDAO citaDAO;

    @Override
    public List<Cita> findAll() {
        return citaDAO.findAll();
    }

    @Override
    public Optional<Cita> findById(Long id) {
        return citaDAO.findById(id);
    }

    @Override
    public void save(Cita cita) {
        citaDAO.save(cita);
    }

    @Override
    public void deleteById(Long id) {
        citaDAO.deleteById(id);
    }
}
