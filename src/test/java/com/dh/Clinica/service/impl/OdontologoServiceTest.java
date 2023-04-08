package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.OdontologoDTO;
import com.dh.Clinica.exceptions.BadRequestException;
import com.dh.Clinica.service.IOdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void crearOdontologoTest() throws BadRequestException {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Tomas");
        odontologoDTO.setApellido("Romano");
        odontologoDTO.setMatricula(122222);

        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontologoBuscado = odontologoService.buscarOdontologo(17L);

        assertTrue(odontologoBuscado != null);
    }
    @Test
    public void buscarOdontologoFantasma() throws BadRequestException{
        OdontologoDTO odontologoFantasma = odontologoService.buscarOdontologo(999L);

        assertTrue(odontologoFantasma == null);
    }
}