package com.ramos.Veterinaria.persistence.impl;

import com.ramos.Veterinaria.entities.Pago;
import com.ramos.Veterinaria.persistence.IPagoDAO;
import com.ramos.Veterinaria.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PagoDAOImpl implements IPagoDAO {

    @Autowired
    private PagoRepository repository;

    @Override
    public List<Pago> findAll() {
        return (List<Pago>) repository.findAll();
    }

    @Override
    public Optional<Pago> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Pago pago) {
        repository.save(pago);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
