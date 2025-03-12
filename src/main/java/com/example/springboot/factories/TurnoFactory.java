package com.example.springboot.factories;

import com.example.springboot.dtos.input.TurnoInputDTO;
import com.example.springboot.models.entities.Mascota;
import com.example.springboot.models.entities.Turno;

public class TurnoFactory {

    public static Turno crearTurno(TurnoInputDTO turnoInputDTO, Mascota mascota) {
        return Turno.builder().mascota(mascota).build();
    }
}
