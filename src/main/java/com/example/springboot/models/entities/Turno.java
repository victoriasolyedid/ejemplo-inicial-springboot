package com.example.springboot.models.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Turno {

    private static Long autoincremental = 1l;

    Long id;

    String razaPaciente;

    String nombrePaciente;

    public Turno() {
        this.id = autoincremental;
        autoincremental++;
    }
}