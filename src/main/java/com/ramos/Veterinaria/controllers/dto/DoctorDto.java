package com.ramos.Veterinaria.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDto {
    private Long idDoctor;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String cedula;
    private String telefono;
    private String domicilio;
}
