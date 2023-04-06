package com.dh.Clinica.dto;

import com.dh.Clinica.entity.Domicilio;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaDeAlta;
    private Domicilio domicilio;

}
