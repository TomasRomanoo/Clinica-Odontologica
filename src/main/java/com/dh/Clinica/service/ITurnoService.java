package com.dh.Clinica.service;

import com.dh.Clinica.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turnoDTO);
    TurnoDTO buscarTurno(Long id);
    void actualizarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
    Set<TurnoDTO> buscarTodosTurnos();
}
