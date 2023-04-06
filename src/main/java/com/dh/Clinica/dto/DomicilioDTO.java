package com.dh.Clinica.dto;

import com.dh.Clinica.entity.Paciente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicilioDTO {
    private String calle;
    private String numero;

    private String localidad;
    private String provincia;

}
