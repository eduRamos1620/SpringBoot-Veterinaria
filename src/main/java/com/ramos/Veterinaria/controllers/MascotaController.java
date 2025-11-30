package com.ramos.Veterinaria.controllers;

import com.ramos.Veterinaria.controllers.dto.DuenioDto;
import com.ramos.Veterinaria.controllers.dto.MascotaDto;
import com.ramos.Veterinaria.entities.Duenios;
import com.ramos.Veterinaria.entities.Mascota;
import com.ramos.Veterinaria.services.IDueniosService;
import com.ramos.Veterinaria.services.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mascota")
public class MascotaController {

    @Autowired
    private IMascotaService serviceMascota;

    @Autowired
    private IDueniosService duenioService;

    @GetMapping("/findAll")
    public ResponseEntity<?> finAll(){
        List<MascotaDto> mascotaList = serviceMascota.findAll().stream()
                .map(mascota -> MascotaDto.builder()
                        .idMascota(mascota.getIdMascota())
                        .nombre(mascota.getNombre())
                        .tipo(mascota.getTipo())
                        .raza(mascota.getRaza())
                        .duenio(mascota.getDuenio())
                        .build())
                .toList();

        return ResponseEntity.ok(mascotaList);
    }

    @GetMapping("/find/{idMascota}")
    public ResponseEntity<?> findById(@PathVariable Long idMascota){
        Optional<Mascota> mascotaOptional =  serviceMascota.findById(idMascota);

        if (mascotaOptional.isPresent()){
            Mascota mascota = mascotaOptional.get();

            MascotaDto mascotaDto = MascotaDto.builder()
                    .idMascota(mascota.getIdMascota())
                    .nombre(mascota.getNombre())
                    .tipo(mascota.getTipo())
                    .raza(mascota.getRaza())
                    .duenio(mascota.getDuenio())
                    .build();

            return ResponseEntity.ok(mascotaDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save (@RequestBody MascotaDto mascotaDto){
        if (mascotaDto.getDuenio() == null && mascotaDto.getDuenio().getIdDuenio() == null){
            return ResponseEntity.badRequest().body("El ID del dueño es obligatorio");
        }

        Duenios duenio = duenioService.findById(mascotaDto.getDuenio().getIdDuenio()).orElseThrow(() ->
                new RuntimeException("Dueño no encontrado con ID: " + mascotaDto.getDuenio().getIdDuenio()));

        serviceMascota.save(Mascota.builder()
                .nombre(mascotaDto.getNombre())
                .tipo(mascotaDto.getTipo())
                .raza(mascotaDto.getRaza())
                .duenio(duenio)
                .build());

        return ResponseEntity.ok("Mascota registrada");
    }

    @PutMapping("/update/{idMascota}")
    public ResponseEntity<?> updateById(@RequestBody MascotaDto mascotaDto, @PathVariable Long idMascota){
        Optional<Mascota> optionalMascota = serviceMascota.findById(idMascota);

        if (optionalMascota.isPresent()){
            Mascota mascota = optionalMascota.get();
            mascota.setNombre(mascotaDto.getNombre());
            mascota.setTipo(mascotaDto.getTipo());
            mascota.setRaza(mascotaDto.getRaza());


            if (mascotaDto.getDuenio() != null && mascotaDto.getDuenio().getIdDuenio() != null){
                Duenios duenio = duenioService.findById(mascotaDto.getDuenio().getIdDuenio()).orElseThrow(() ->
                        new RuntimeException("Dueño no encontrado con ID: " + mascotaDto.getDuenio().getIdDuenio()));

                mascota.setDuenio(duenio);
            }

            serviceMascota.save(mascota);

            return ResponseEntity.ok("Datos de la mascota actualizados");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{idMascota}")
    @Transactional()
    public String deleteById(@PathVariable Long idMascota){
        if (idMascota != null){
            serviceMascota.deleteById(idMascota);
            return "Se elimino la mascota";
        }
        return "No se pudo eliminar la mascota";
    }
}
