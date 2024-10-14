package com.example.springboot.models.repositories;

import com.example.springboot.models.entities.Turno;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class RepositoryOnMem implements  TurnoRepository {

    private static List<Turno> turnos = new ArrayList<>();

    public List<Turno> findAll() {
        return turnos;
    }

    @Override
    public void eliminarTurno(Long id) {
        turnos = turnos.stream().filter(t -> !t.getId().equals(id)).toList();
    }

    @Override
    public Turno findById(Long id) {
       return turnos.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Turno turno) {
       turnos.add(turno);
    }


}
