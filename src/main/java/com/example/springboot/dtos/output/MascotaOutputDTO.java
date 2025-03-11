package com.example.springboot.dtos.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MascotaOutputDTO {

    private Long id;

    private String nombre;

    private String raza;
}
