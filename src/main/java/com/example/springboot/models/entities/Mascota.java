package com.example.springboot.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String raza;

    @Column(nullable = false)
    private String nombre;

}
