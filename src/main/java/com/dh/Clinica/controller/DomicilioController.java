package com.dh.Clinica.controller;

import com.dh.Clinica.dto.DomicilioDTO;
import com.dh.Clinica.service.IDomicilioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    IDomicilioService domicilioService;

    @GetMapping("/{id}")
    public DomicilioDTO traerDomicilio(@PathVariable Long id){
        return domicilioService.buscarDomicilio(id);
    }

    @GetMapping
    public Collection<DomicilioDTO> traerTodosDomicilios(){
        return domicilioService.buscarTodosDomicilios();
    }

    @PostMapping
    public ResponseEntity<?> crearDomicilio(@Valid @RequestBody DomicilioDTO domicilioDTO){
        domicilioService.crearDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modificarDomicilio(@Valid @RequestBody DomicilioDTO domicilioDTO){
        domicilioService.actualizarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id){
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}