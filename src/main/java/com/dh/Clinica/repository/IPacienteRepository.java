package com.dh.Clinica.repository;

import com.dh.Clinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    @Query("from Paciente s where s.dni = :dni")
    Optional<Paciente> traerDni(@Param("dni") String dni);
}
