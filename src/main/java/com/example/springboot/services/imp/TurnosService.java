package com.example.springboot.services.imp;

import com.example.springboot.dtos.input.TurnoInputDTO;
import com.example.springboot.dtos.output.TurnoOutputDTO;
import com.example.springboot.exceptions.NotFoundException;
import com.example.springboot.factories.MascotaFactory;
import com.example.springboot.factories.TurnoFactory;
import com.example.springboot.mappers.TurnoMapper;
import com.example.springboot.models.entities.Mascota;
import com.example.springboot.models.entities.Turno;
import com.example.springboot.models.repositories.MascotaRepository;
import com.example.springboot.models.repositories.TurnoRepository;
import com.example.springboot.services.ITurnosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnosService implements ITurnosService {
    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    //GET
    @Override
    public List<TurnoOutputDTO> obtenerTodos() {
        return this.turnoRepository.findAll().stream().map(TurnoMapper::crearAPartirDe).toList();
    }

    @Override
    public TurnoOutputDTO obtenerPorId(Long id) {
        Optional<Turno> turno = this.turnoRepository.findById(id);

        return turno.map(TurnoMapper::crearAPartirDe).orElse(null);

    }
    //CREATE (POST)
    @Override
    public Long crearTurno(TurnoInputDTO turno) {

        Mascota mascota = mascotaRepository.findById(turno.getMascota().getId()).orElse(null);

        if (mascota == null) {
            mascota = MascotaFactory.crearMascota(turno);
            mascotaRepository.save(mascota);
        }

        Turno nuevoTurno = TurnoFactory.crearTurno(turno, mascota);
        this.turnoRepository.save(nuevoTurno);
        return nuevoTurno.getId();
    }

    //UPDATE (PUT)
    public TurnoOutputDTO modificarTurno(TurnoInputDTO turno, Long id) {

        Turno turnoAModificar = new ObjectMapper().convertValue(turno, Turno.class);

        if (turnoRepository.existsById(id)) {
            this.turnoRepository.save(turnoAModificar);
            return TurnoMapper.crearAPartirDe(turnoAModificar);
        }

        return null;
    }

    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }


    public TurnoOutputDTO buscarPorId(Long id) {
        Optional<Turno> turno = this.turnoRepository.findById(id);

        return turno.map(TurnoMapper::crearAPartirDe).orElse(null);

    }

}
