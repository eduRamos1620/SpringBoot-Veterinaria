package com.ramos.Veterinaria.controllers.dto;

import com.ramos.Veterinaria.entities.Mascota;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DuenioDto {
    private Long idDuenio;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String correo;
    private List<Mascota> mascotas;
}
