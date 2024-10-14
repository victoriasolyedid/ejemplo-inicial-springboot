package com.example.springboot.services.imp;

import com.example.springboot.dtos.input.TurnoInputDTO;
import com.example.springboot.dtos.output.TurnoOutputDTO;
import com.example.springboot.exceptions.NotFoundException;
import com.example.springboot.mappers.TurnoMapper;
import com.example.springboot.models.entities.Turno;
import com.example.springboot.models.repositories.TurnoRepository;
import com.example.springboot.services.ITurnosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnosService implements ITurnosService {
    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public List<TurnoOutputDTO> buscarTodos() {
        return this.turnoRepository.findAll().stream().map(TurnoMapper::crearAPartirDe).toList();
    }

    @Override
    public TurnoOutputDTO buscarPorId(Long id) {
        return TurnoMapper.crearAPartirDe(buscarTurno(id));
    }

    @Override
    public Long crearTurno(TurnoInputDTO turno) {
        Turno nuevoTurno = new ObjectMapper().convertValue(turno, Turno.class);
        this.turnoRepository.save(nuevoTurno);
        return nuevoTurno.getId();
    }

    @Override
    public void eliminarTurno(Long id) {
        //TODO
    }

    @Override
    public TurnoOutputDTO modificarTurno(TurnoInputDTO turno, Long id) {
        //TODO
        return null;
    }

    private Turno buscarTurno(Long id) {
        return turnoRepository
                .findById(id);
               // .orElseThrow(() -> new NotFoundException("No existe un turno de id " + id));
    }
}
