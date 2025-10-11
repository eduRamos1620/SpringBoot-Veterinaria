package com.ramos.Veterinaria.persistence.impl;

import com.ramos.Veterinaria.entities.Cita;
import com.ramos.Veterinaria.persistence.ICitaDAO;
import com.ramos.Veterinaria.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CitaDAOImpl implements ICitaDAO {

    @Autowired
    private CitaRepository repository;

    @Override
    public List<Cita> findAll() {
        return (List<Cita>) repository.findAll();
    }

    @Override
    public Optional<Cita> findById(Long idCita) {
        return repository.findById(idCita);
    }

    @Override
    public void save(Cita cita) {
        repository.save(cita);
    }

    @Override
    public void deleteById(Long idCita) {
        repository.deleteById(idCita);
    }
}
