package com.ramos.Veterinaria.services.impl;

import com.ramos.Veterinaria.entities.Cita;
import com.ramos.Veterinaria.persistence.ICitaDAO;
import com.ramos.Veterinaria.services.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CitaServiceImpl implements ICitaService {

    @Autowired
    private ICitaDAO citaDAO;

    @Override
    public List<Cita> findAll() {
        return citaDAO.findAll();
    }

    @Override
    public ResponseEntity<?> findById(Long idCita) {
        return citaDAO.findById(idCita);
    }

    @Override
    public void save(Cita cita) {
        citaDAO.save(cita);
    }

    @Override
    public void deleteById(Long idCita) {
        citaDAO.deleteById(idCita);
    }
}
