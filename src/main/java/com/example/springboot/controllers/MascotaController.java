package com.example.springboot.controllers;

import com.example.springboot.dtos.input.MascotaInputDTO;
import com.example.springboot.dtos.input.TurnoInputDTO;
import com.example.springboot.dtos.output.MascotaOutputDTO;
import com.example.springboot.dtos.output.TurnoOutputDTO;
import com.example.springboot.services.IMascotaService;
import com.example.springboot.services.ITurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private IMascotaService mascotaService;

    @PostMapping
    public ResponseEntity<String> cargarMascota(@RequestBody MascotaInputDTO mascota){
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.mascotaService.crearMascota(mascota).toString());

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id){
        this.mascotaService.eliminarMascota(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    // Devolvemos la mascota en la response entity para poder entender si funciono o no la modificacion
    @PutMapping("/{id}")
    public ResponseEntity<MascotaOutputDTO> modificarMascota(@RequestBody MascotaInputDTO mascotaNueva, @PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mascotaService.modificarMascota(mascotaNueva, id));
    }



}
