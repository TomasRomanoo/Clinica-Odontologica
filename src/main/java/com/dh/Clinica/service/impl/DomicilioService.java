package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.DomicilioDTO;
import com.dh.Clinica.entity.Domicilio;
import com.dh.Clinica.repository.IDomicilioRepository;
import com.dh.Clinica.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {
    @Autowired
    private IDomicilioRepository domicilioRepository;
    @Autowired
    ObjectMapper mapper;


    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    @Override
    public DomicilioDTO buscarDomicilio(Long id) {
        Optional<Domicilio> domicilio= domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if(domicilio.isPresent())
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        return domicilioDTO;
    }

    @Override
    public void actualizarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public Set<DomicilioDTO> buscarTodosDomicilios() {
        List<Domicilio> domicilios = domicilioRepository.findAll();

        Set<DomicilioDTO>domiciliosDTO = new HashSet<>();
        for (Domicilio domicilio: domicilios){
            domiciliosDTO.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return domiciliosDTO;
    }
}
