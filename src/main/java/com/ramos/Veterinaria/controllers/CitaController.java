package com.ramos.Veterinaria.controllers;

import com.ramos.Veterinaria.controllers.dto.CitaDto;
import com.ramos.Veterinaria.entities.Cita;
import com.ramos.Veterinaria.services.ICitaService;
import com.ramos.Veterinaria.services.impl.CitaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/cita")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    @GetMapping("/find/{id}")
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
}
