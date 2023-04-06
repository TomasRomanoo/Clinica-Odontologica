package com.dh.Clinica.controller;

import com.dh.Clinica.dto.TurnoDTO;
import com.dh.Clinica.service.ITurnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @GetMapping("/{id}")
    public TurnoDTO traerTurno(@PathVariable Long id){
        return turnoService.buscarTurno(id);
    }

    @GetMapping
    public Collection<TurnoDTO> traerTodosTurnos(){
        return turnoService.buscarTodosTurnos();
    }

    @PostMapping
    public ResponseEntity<?> crearTurno(@Valid @RequestBody TurnoDTO turnoDTO){
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@Valid @RequestBody TurnoDTO turnoDTO){
        turnoService.actualizarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
