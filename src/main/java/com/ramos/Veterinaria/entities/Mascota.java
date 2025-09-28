package com.ramos.Veterinaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long idMascota;

    private String nombre;

    @NotBlank
    private String tipo;

    private String raza;

    @ManyToOne(targetEntity = Duenios.class)
    @JoinColumn(name = "id_duenio")
    private Duenios duenio;
}
