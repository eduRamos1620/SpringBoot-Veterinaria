package com.ramos.Veterinaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long idPago;

    @NotBlank
    @Column(name = "tipo_pago")
    private String tipoPago;

    @NotNull
    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @NotNull
    private BigDecimal monto;

    @OneToOne(targetEntity = Cita.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cita")
    private Cita cita;
}
