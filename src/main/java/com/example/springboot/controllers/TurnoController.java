package com.example.springboot.controllers;

import com.example.springboot.dtos.input.TurnoInputDTO;
import com.example.springboot.dtos.output.TurnoOutputDTO;
import com.example.springboot.services.ITurnosService;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnosService turnosService;

    @GetMapping
    public ResponseEntity<List<TurnoOutputDTO>> obtenerTurnos(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.turnosService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<String> cargarTurno(@RequestBody @Valid TurnoInputDTO turno, BindingResult bindingResult){


        if(!bindingResult.hasErrors()) {
            return  ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.turnosService.crearTurno(turno).toString());
        }

        else{
            return ResponseEntity.badRequest().body("Validation failed " + bindingResult.getAllErrors());
        }


    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoOutputDTO> obtenerTurnoPorId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.turnosService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTurno(@PathVariable Long id){
        this.turnosService.eliminarTurno(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoOutputDTO> putTurno(@RequestBody TurnoInputDTO turnoNuevo, @PathVariable Long id){


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.turnosService.modificarTurno(turnoNuevo, id));
    }
}