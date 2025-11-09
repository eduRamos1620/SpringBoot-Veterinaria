package com.ramos.Veterinaria.controllers.dto;

import com.ramos.Veterinaria.entities.Cita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagoDTO {
    private Long idPago;
    private String tipoPago;
    private LocalDateTime fechaPago;
    private BigDecimal monto;
    private Cita cita;
}
