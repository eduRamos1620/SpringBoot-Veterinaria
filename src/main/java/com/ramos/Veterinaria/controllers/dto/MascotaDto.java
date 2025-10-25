package com.ramos.Veterinaria.controllers.dto;

import com.ramos.Veterinaria.entities.Duenios;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MascotaDto {
    private Long idMascota;
    private String nombre;
    private String tipo;
    private String raza;
    private Duenios duenio;
}
