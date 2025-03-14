package com.example.springboot.dtos.input;

import com.example.springboot.models.entities.Mascota;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Data
@Getter
@Setter
public class TurnoInputDTO {

    private Mascota mascota;

}
