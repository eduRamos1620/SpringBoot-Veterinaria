package com.ramos.Veterinaria.controllers;

import com.ramos.Veterinaria.controllers.dto.CitaDto;
import com.ramos.Veterinaria.entities.Cita;
import com.ramos.Veterinaria.services.ICitaService;
import com.ramos.Veterinaria.services.impl.CitaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cita")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    @GetMapping("/find/{idCita}")
    public ResponseEntity<?> findById(@PathVariable Long idCita) {
        Optional<Cita> citaOptional = citaService.findById(idCita);

        if(citaOptional.isPresent()){
            Cita cita = citaOptional.get();
            CitaDto citaDto = CitaDto.builder()
                    .idCita(cita.getIdCita())
                    .fecha(cita.getFecha())
                    .hora(cita.getHora())
                    .doctor(cita.getDoctor())
                    .duenio(cita.getDuenio())
                    .mascota(cita.getMascota())
                    .build();
            return ResponseEntity.ok(citaDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<CitaDto> citas = citaService.findAll().stream()
                .map(cita -> CitaDto.builder()
                        .idCita(cita.getIdCita())
                        .fecha(cita.getFecha())
                        .hora(cita.getHora())
                        .doctor(cita.getDoctor())
                        .duenio(cita.getDuenio())
                        .mascota(cita.getMascota())
                        .build())
                .toList();
        return ResponseEntity.ok(citas);
    }

    @PostMapping("/save")
    public String save(@RequestBody CitaDto citaDto){
        citaService.save(Cita.builder()
                .fecha(citaDto.getFecha())
                //.fecha(LocalDate.now())
                .hora(citaDto.getHora())
                //.hora(LocalTime.now())
                .doctor(citaDto.getDoctor())
                .duenio(citaDto.getDuenio())
                .mascota(citaDto.getMascota())
                .build());

        return "Cita guardada correctamente";
    }

    @PutMapping("/update/{idCita}")
    @Transactional
    public String update(@RequestBody CitaDto citaDto, @PathVariable Long idCita){
        Optional<Cita> citaOptional = citaService.findById(idCita);

        if (citaOptional.isPresent()){
            Cita cita = citaOptional.get();
            cita.setFecha(citaDto.getFecha());
            cita.setHora(citaDto.getHora());
            cita.setDoctor(citaDto.getDoctor());
            cita.setDuenio(citaDto.getDuenio());
            cita.setMascota(citaDto.getMascota());

            return "Cita actualizada correctamente";
        }
        return "Cita no encontrada";
    }

    @DeleteMapping("/delete/{idCita}")
    public String deleteById(@PathVariable Long idCita){
        if (idCita != null){
            citaService.deleteById(idCita);
            return "Cita eliminada exitosamente";
        }
        return "Cita no encontrada";
    }
}
