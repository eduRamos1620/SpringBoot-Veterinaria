package com.ramos.Veterinaria.services.impl;

import com.ramos.Veterinaria.entities.Mascota;
import com.ramos.Veterinaria.persistence.IMascotaDAO;
import com.ramos.Veterinaria.services.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaServiceImpl implements IMascotaService {

    @Autowired
    private IMascotaDAO mascotaDAO;

    @Override
    public List<Mascota> findAll() {
        return mascotaDAO.findAll();
    }

    @Override
    public Optional<Mascota> findById(Long idMascota) {
        return mascotaDAO.findById(idMascota);
    }

    @Override
    public void save(Mascota mascota) {
        mascotaDAO.save(mascota);
    }

    @Override
    public void deleteById(Long idMascota) {
        mascotaDAO.deleteById(idMascota);
    }
}
