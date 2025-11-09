package com.ramos.Veterinaria.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @JsonBackReference
    private Duenios duenio;
}
