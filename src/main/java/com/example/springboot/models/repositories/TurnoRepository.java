package com.example.springboot.models.repositories;

import com.example.springboot.models.entities.Turno;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnoRepository {

    List<Turno> findAll();

    void eliminarTurno(Long id);

    Turno findById(Long id);

    void save(Turno turno);



}