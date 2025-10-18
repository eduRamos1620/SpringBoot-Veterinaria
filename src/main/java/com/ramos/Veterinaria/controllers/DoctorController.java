package com.ramos.Veterinaria.controllers;

import com.ramos.Veterinaria.controllers.dto.DoctorDto;
import com.ramos.Veterinaria.entities.Doctor;
import com.ramos.Veterinaria.services.IDoctorService;
import com.ramos.Veterinaria.services.impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private IDoctorService serviceDoctor;

    @GetMapping("/find/{idDoctor}")
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

    @GetMapping("/findAll")
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

    @PostMapping("/save")
    public ResponseEntity<?> save (@RequestBody DoctorDto doctorDto){
        if (doctorDto.getNombre().isBlank() && doctorDto.getApellidoPaterno().isBlank() && doctorDto.getCedula().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        serviceDoctor.save(Doctor.builder()
                .nombre(doctorDto.getNombre())
                .apellidoPaterno(doctorDto.getApellidoPaterno())
                .apellidoMaterno(doctorDto.getApellidoMaterno())
                .cedula(doctorDto.getCedula())
                .telefono(doctorDto.getTelefono())
                .domicilio(doctorDto.getDomicilio())
                .build());

        return ResponseEntity.ok("Doctor agregado correctamente");
    }

    @PutMapping("/update/{idDoctor}")
    public ResponseEntity<?> updateDoctor(@PathVariable Long idDoctor, @RequestBody DoctorDto doctorDto){
        Optional<Doctor> optionalDoctor = serviceDoctor.findById(idDoctor);

        if(optionalDoctor.isPresent()){
            Doctor doctor = optionalDoctor.get();
            doctor.setNombre(doctorDto.getNombre());
            doctor.setApellidoPaterno(doctorDto.getApellidoPaterno());
            doctor.setApellidoMaterno(doctorDto.getApellidoMaterno());
            doctor.setCedula(doctorDto.getCedula());
            doctor.setTelefono(doctorDto.getTelefono());
            doctor.setDomicilio(doctorDto.getDomicilio());

            serviceDoctor.save(doctor);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{idDoctor}")
    public ResponseEntity<?> deleteById(@PathVariable Long idDoctor){
        if (idDoctor != null){
            serviceDoctor.deleteById(idDoctor);
            return ResponseEntity.ok("Registsro eliminado");
        }
        return ResponseEntity.notFound().build();
    }
}
