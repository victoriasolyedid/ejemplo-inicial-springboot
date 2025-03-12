package com.example.springboot.dtos.input;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class MascotaInputDTO {

    private String raza;


    private String nombre;

}
