package com.example.springboot.dtos.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class TurnoInputDTO {

    @NotNull(message = "El nombre no debe estar vacio" )
    private String razaPaciente;

    @NotEmpty(message = "El nombre no debe estar vacio")
    private String nombrePaciente;

}
