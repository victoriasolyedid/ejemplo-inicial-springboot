package com.example.springboot.services.imp;

import com.example.springboot.dtos.input.MascotaInputDTO;
import com.example.springboot.dtos.output.MascotaOutputDTO;
import com.example.springboot.dtos.output.TurnoOutputDTO;
import com.example.springboot.mappers.MascotaMapper;
import com.example.springboot.mappers.TurnoMapper;
import com.example.springboot.models.entities.Mascota;
import com.example.springboot.models.entities.Turno;
import com.example.springboot.models.repositories.MascotaRepository;
import com.example.springboot.services.IMascotaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public Long crearMascota(MascotaInputDTO mascota) {
        //El ObjectMapper me permite transformar el Input en una clase de dominio
        // A veces no funciona
        Mascota nuevaMascota = new ObjectMapper().convertValue(mascota, Mascota.class);
        this.mascotaRepository.save(nuevaMascota);
        return nuevaMascota.getId();
    }

    @Override
    public void eliminarMascota(Long id) {
        this.mascotaRepository.deleteById(id);

    }

    @Override
    public MascotaOutputDTO obtenerPorId(Long id) {
        Optional<Mascota> mascotaBuscada = this.mascotaRepository.findById(id);

        //Builder
        return mascotaBuscada.map(MascotaMapper::crearAPartirDe).orElse(null);

    }

    @Override
    public MascotaOutputDTO modificarMascota(MascotaInputDTO mascota, Long id) {

        if(mascotaRepository.existsById(id)) {
            Mascota mascotaAActualizar = new ObjectMapper().convertValue(mascota, Mascota.class);
            mascotaRepository.save(mascotaAActualizar);
            return MascotaMapper.crearAPartirDe(mascotaAActualizar);
        }
        return null;
    }
}
