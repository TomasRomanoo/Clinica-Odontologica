package com.dh.Clinica.service;

import com.dh.Clinica.dto.OdontologoDTO;
import com.dh.Clinica.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface IOdontologoService {
    void crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException;
    OdontologoDTO buscarOdontologo(Long id);
    void actualizarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);
    Set<OdontologoDTO> buscarTodosOdontologos();
}
