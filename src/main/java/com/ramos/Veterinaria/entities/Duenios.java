package com.ramos.Veterinaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Duenios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_duenio")
    private Long idDuenio;

    @NotBlank
    private String nombre;

    @NotBlank
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @NotBlank
    @Min(value = 10)
    private String telefono;

    private String correo;

    @OneToMany(targetEntity = Mascota.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "duenio")
    private List<Mascota> mascotas;
}
