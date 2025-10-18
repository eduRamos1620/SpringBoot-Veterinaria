package com.ramos.Veterinaria.services.impl;

import com.ramos.Veterinaria.entities.Doctor;
import com.ramos.Veterinaria.persistence.IDoctorDAO;
import com.ramos.Veterinaria.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorDAO doctorDAO;

    @Override
    public List<Doctor> findAll() {
        return doctorDAO.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long idDoctor) {

        return doctorDAO.findById(idDoctor);
    }

    @Override
    public void save(Doctor doctor) {
        doctorDAO.save(doctor);
    }

    @Override
    public void deleteById(Long idDoctor) {
        doctorDAO.deleteById(idDoctor);
    }
}
