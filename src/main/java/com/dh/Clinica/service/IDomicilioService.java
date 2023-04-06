package com.dh.Clinica.service;

import com.dh.Clinica.dto.DomicilioDTO;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface IDomicilioService {
    void crearDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO buscarDomicilio(Long id);
    void actualizarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(Long id);
    Set<DomicilioDTO> buscarTodosDomicilios();
}
