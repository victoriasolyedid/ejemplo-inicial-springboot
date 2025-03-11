package com.example.springboot.services;

import com.example.springboot.dtos.input.MascotaInputDTO;
import com.example.springboot.dtos.output.MascotaOutputDTO;

import java.util.List;

public interface IMascotaService {
    Long crearMascota(MascotaInputDTO mascota);
    void eliminarMascota(Long id);
    MascotaOutputDTO obtenerPorId(Long id);
    MascotaOutputDTO modificarMascota(MascotaInputDTO mascota, Long id);
}
