package com.ramos.Veterinaria.controllers;

import com.ramos.Veterinaria.controllers.dto.DoctorDto;
import com.ramos.Veterinaria.entities.Doctor;
import com.ramos.Veterinaria.services.IDoctorService;
import com.ramos.Veterinaria.services.impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private IDoctorService serviceDoctor;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long idDoctor){
        Optional<Doctor> doctorOptional = serviceDoctor.findById(idDoctor);
        if(doctorOptional.isPresent()){
            Doctor doctor = doctorOptional.get();

            DoctorDto doctorDto = DoctorDto.builder()
                    .idDoctor(doctor.getIdDoctor())
                    .nombre(doctor.getNombre())
                    .apellidoPaterno(doctor.getApellidoPaterno())
                    .apellidoMaterno(doctor.getApellidoMaterno())
                    .cedula(doctor.getCedula())
                    .telefono(doctor.getTelefono())
                    .domicilio(doctor.getDomicilio())
                    .build();

            return ResponseEntity.ok(doctorDto);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> findAll(){
        List<DoctorDto> doctorList = serviceDoctor.findAll().stream()
                .map( doctor -> DoctorDto.builder()
                        .idDoctor(doctor.getIdDoctor())
                        .nombre(doctor.getNombre())
                        .apellidoPaterno(doctor.getApellidoPaterno())
                        .apellidoMaterno(doctor.getApellidoMaterno())
                        .cedula(doctor.getCedula())
                        .telefono(doctor.getTelefono())
                        .domicilio(doctor.getDomicilio())
                        .build())
                .toList();

        return ResponseEntity.ok(doctorList);
    }

    public ResponseEntity<?>
}
