package com.example.springboot.mappers;

import com.example.springboot.dtos.output.TurnoOutputDTO;
import com.example.springboot.models.entities.Turno;

public class TurnoMapper {

    public static TurnoOutputDTO crearAPartirDe(Turno turno) {
        return TurnoOutputDTO
                .builder()
                .id(turno.getId())
                .mascota(turno.getMascota())
                .build();
    }
}
