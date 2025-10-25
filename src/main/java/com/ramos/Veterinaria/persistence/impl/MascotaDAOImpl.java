package com.ramos.Veterinaria.persistence.impl;

import com.ramos.Veterinaria.entities.Mascota;
import com.ramos.Veterinaria.persistence.IMascotaDAO;
import com.ramos.Veterinaria.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MascotaDAOImpl implements IMascotaDAO {

    @Autowired
    private MascotaRepository repository;

    @Override
    public List<Mascota> findAll() {
        return (List<Mascota>) repository.findAll();
    }

    @Override
    public Optional<Mascota> findById(Long idMascota) {
        return repository.findById(idMascota);
    }

    @Override
    public void save(Mascota mascota) {
        repository.save(mascota);
    }

    @Override
    public void deleteById(Long idMascota) {
        repository.deleteById(idMascota);
    }
}
