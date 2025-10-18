package com.ramos.Veterinaria.services.impl;

import com.ramos.Veterinaria.entities.Pago;
import com.ramos.Veterinaria.persistence.IPagoDAO;
import com.ramos.Veterinaria.services.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements IPagoService {

    @Autowired
    private IPagoDAO pagoDAO;

    @Override
    public List<Pago> findAll() {
        return pagoDAO.findAll();
    }

    @Override
    public Optional<Pago> findById(Long id) {
        return pagoDAO.findById(id);
    }

    @Override
    public void save(Pago pago) {
        pagoDAO.save(pago);
    }

    @Override
    public void deleteById(Long id) {
        pagoDAO.deleteById(id);
    }
}
