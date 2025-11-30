package com.ramos.Veterinaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita;

    @NotNull
    private LocalDate fecha;

    @NotNull
    private LocalTime hora;

    @ManyToOne(targetEntity = Doctor.class)
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @ManyToOne(targetEntity = Duenios.class)
    @JoinColumn(name = "id_duenio")
    private Duenios duenio;

    @ManyToOne(targetEntity = Mascota.class)
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;
}
