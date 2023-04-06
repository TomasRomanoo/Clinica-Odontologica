package com.dh.Clinica.service;

import com.dh.Clinica.dto.PacienteDTO;
import com.dh.Clinica.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface IPacienteService {
    void crearPaciente(PacienteDTO pacienteDTO) throws BadRequestException;
    PacienteDTO buscarPaciente(Long id);
    void actualizarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id);
    Set<PacienteDTO> buscarTodosPacientes();
}
