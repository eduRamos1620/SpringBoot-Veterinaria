package com.ramos.Veterinaria.persistence.impl;

import com.ramos.Veterinaria.entities.Doctor;
import com.ramos.Veterinaria.persistence.IDoctorDAO;
import com.ramos.Veterinaria.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DoctorDAOImpl implements IDoctorDAO {

    @Autowired
    private DoctorRepository repository;

    @Override
    public List<Doctor> findAll() {
        return (List<Doctor>) repository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Doctor doctor) {
        repository.save(doctor);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
