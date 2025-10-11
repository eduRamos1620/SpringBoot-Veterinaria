package com.ramos.Veterinaria.controllers.dto;

import com.ramos.Veterinaria.entities.Doctor;
import com.ramos.Veterinaria.entities.Duenios;
import com.ramos.Veterinaria.entities.Mascota;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitaDto {
    private Long idCita;
    private LocalDate fecha;
    private LocalTime hora;
    private Doctor doctor;
    private Duenios duenio;
    private Mascota mascota;
}
