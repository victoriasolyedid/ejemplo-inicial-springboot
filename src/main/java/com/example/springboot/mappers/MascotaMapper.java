package com.example.springboot.mappers;

import com.example.springboot.dtos.output.MascotaOutputDTO;
import com.example.springboot.models.entities.Mascota;


//Los mapper no son component porque no lelvan logica de negocio
public class MascotaMapper {

    public static MascotaOutputDTO crearAPartirDe(Mascota mascota){
        return MascotaOutputDTO.builder()
                .id(mascota.getId())
                .raza(mascota.getRaza())
                .nombre(mascota.getNombre())
                .build();

    }
}
