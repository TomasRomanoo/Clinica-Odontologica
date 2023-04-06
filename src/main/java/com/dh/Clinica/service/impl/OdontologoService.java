package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.OdontologoDTO;
import com.dh.Clinica.entity.Odontologo;
import com.dh.Clinica.exceptions.BadRequestException;
import com.dh.Clinica.repository.IOdontologoRepository;
import com.dh.Clinica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        /*codigo nuevo*/
        int matricula = odontologoDTO.getMatricula();
        Optional<Odontologo> odontologoExistente = odontologoRepository.traerMatricula(matricula);
        if (odontologoExistente.isPresent()) {
            throw new BadRequestException("La matrícula ya está registrada");
        }
        /*hasta aca*/
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }
    /*exception*/
    public Optional<Odontologo> traerPorMatricula(int matricula) {
        return odontologoRepository.traerMatricula(matricula);
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent())
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        return odontologoDTO;
    }

    @Override
    public void actualizarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> buscarTodosOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();

        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo: odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }

}
