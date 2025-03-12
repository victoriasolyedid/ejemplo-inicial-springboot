package com.example.springboot.factories;

import com.example.springboot.dtos.input.TurnoInputDTO;
import com.example.springboot.models.entities.Mascota;
import com.example.springboot.models.entities.Turno;

public class MascotaFactory {

    public static Mascota crearMascota(TurnoInputDTO turno) {
        return Mascota.builder()
                .id(2L)
                .raza(turno.getMascota().getRaza())
                .nombre(turno.getMascota().getNombre())
                .build();
    }
}
