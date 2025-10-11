package com.ramos.Veterinaria.services.impl;

import com.ramos.Veterinaria.entities.Mascota;
import com.ramos.Veterinaria.persistence.IMascotaDAO;
import com.ramos.Veterinaria.services.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MascotaServiceImpl implements IMascotaService {

    @Autowired
    private IMascotaDAO mascotaDAO;

    @Override
    public List<Mascota> findAll() {
        return mascotaDAO.findAll();
    }

    @Override
    public Optional<Mascota> findById(Long id) {
        return mascotaDAO.findById(id);
    }

    @Override
    public void save(Mascota mascota) {
        mascotaDAO.save(mascota);
    }

    @Override
    public void deleteById(Long id) {
        mascotaDAO.deleteById(id);
    }
}
