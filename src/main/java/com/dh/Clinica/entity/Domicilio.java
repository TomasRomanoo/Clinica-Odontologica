package com.dh.Clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Domicilio {
    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)*/
    /*@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;*/

    @OneToOne(mappedBy = "domicilio")
    @JsonIgnore
    private Paciente paciente;
}