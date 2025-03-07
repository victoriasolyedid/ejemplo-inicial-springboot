package com.example.springboot.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Turno {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String razaPaciente;

    @Column(nullable = false)
    private String nombrePaciente;


}