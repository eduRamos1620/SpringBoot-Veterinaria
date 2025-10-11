package com.ramos.Veterinaria.services;

import com.ramos.Veterinaria.entities.Doctor;

import java.util.List;
import java.util.Optional;

public interface IDoctorService {

    List<Doctor> findAll();

    Optional<Doctor> findById(Long id);

    void save(Doctor doctor);

    void deleteById(Long id);
}
