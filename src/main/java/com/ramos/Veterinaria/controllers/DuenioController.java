package com.ramos.Veterinaria.controllers;

import com.ramos.Veterinaria.controllers.dto.DuenioDto;
import com.ramos.Veterinaria.controllers.dto.MascotaDto;
import com.ramos.Veterinaria.entities.Duenios;
import com.ramos.Veterinaria.services.IDueniosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/duenio")
public class DuenioController {

    @Autowired
    private IDueniosService serviceDuenio;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<DuenioDto> duenioList = serviceDuenio.findAll().stream()
                .map(
                    duenio -> DuenioDto.builder()
                            .idDuenio(duenio.getIdDuenio())
                            .nombre(duenio.getNombre())
                            .apellidoPaterno(duenio.getApellidoPaterno())
                            .apellidoMaterno(duenio.getApellidoMaterno())
                            .telefono(duenio.getTelefono())
                            .correo(duenio.getCorreo())
                            .mascotas(duenio.getMascotas())
                            .build())
                .toList();

        return ResponseEntity.ok(duenioList);
    }

    @GetMapping("/find/{idDuenio}")
    public ResponseEntity<?> findById(@PathVariable Long idDuenio){
        Optional<Duenios> dueniosOptional = serviceDuenio.findById(idDuenio);

        if (dueniosOptional.isPresent()){
            Duenios duenios = dueniosOptional.get();

            DuenioDto duenioDto = DuenioDto.builder()
                    .idDuenio(duenios.getIdDuenio())
                    .nombre(duenios.getNombre())
                    .apellidoPaterno(duenios.getApellidoPaterno())
                    .apellidoMaterno(duenios.getApellidoMaterno())
                    .telefono(duenios.getTelefono())
                    .correo(duenios.getCorreo())
                    .mascotas(duenios.getMascotas())
                    .build();

            return ResponseEntity.ok(duenioDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody DuenioDto duenioDto){
        serviceDuenio.save(Duenios.builder()
                .nombre(duenioDto.getNombre())
                .apellidoPaterno(duenioDto.getApellidoPaterno())
                .apellidoMaterno(duenioDto.getApellidoMaterno())
                .telefono(duenioDto.getTelefono())
                .correo(duenioDto.getCorreo())
                .mascotas(duenioDto.getMascotas())
                .build()
        );

        return ResponseEntity.ok("Dueño Agregado Correctamente");
    }

    @PutMapping("/update/{idDuenio}")
    public ResponseEntity<?> updateById(@RequestBody DuenioDto duenioDto, @PathVariable Long idDuenio){
        Optional<Duenios> dueniosOptional =serviceDuenio.findById(idDuenio);

        if (dueniosOptional.isPresent()){
            Duenios duenios = dueniosOptional.get();
            duenios.setNombre(duenioDto.getNombre());
            duenios.setApellidoPaterno(duenioDto.getApellidoPaterno());
            duenios.setApellidoMaterno(duenioDto.getApellidoMaterno());
            duenios.setTelefono(duenioDto.getTelefono());
            duenios.setCorreo(duenioDto.getCorreo());
            duenios.setMascotas(duenioDto.getMascotas());

            serviceDuenio.save(duenios);
            return ResponseEntity.ok("Se actualizo el duenio correctamente");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{idDuenio}")
    public ResponseEntity<?> deleteById(@PathVariable Long idDuenio){
        if (idDuenio != null){
            serviceDuenio.deleteById(idDuenio);
            return ResponseEntity.ok("Eliminado Correctamente");
        }
        return ResponseEntity.notFound().build();
    }
}
