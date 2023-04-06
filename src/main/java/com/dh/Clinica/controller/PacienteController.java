package com.dh.Clinica.controller;

import com.dh.Clinica.dto.PacienteDTO;
import com.dh.Clinica.service.IPacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @GetMapping("/{id}")
    public PacienteDTO traerPaciente(@PathVariable Long id){
        return pacienteService.buscarPaciente(id);
    }

    @GetMapping
    public Collection<PacienteDTO> traerTodosPacientes(){
        return pacienteService.buscarTodosPacientes();
    }

    @PostMapping
    public ResponseEntity<?> crearPaciente(@Valid @RequestBody PacienteDTO pacienteDTO){
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@Valid @RequestBody PacienteDTO pacienteDTO){
        pacienteService.actualizarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

