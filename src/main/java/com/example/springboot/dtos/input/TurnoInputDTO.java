package com.example.springboot.dtos.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
public class TurnoInputDTO {

    private String razaPaciente;

    private String nombrePaciente;

}
