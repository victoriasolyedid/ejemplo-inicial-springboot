package com.example.springboot.dtos.output;

import com.example.springboot.models.entities.Mascota;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TurnoOutputDTO {
    private Long id;
    private Mascota mascota;
}
