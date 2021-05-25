package com.umanizales.api_batalla_naval.controller;

import com.umanizales.api_batalla_naval.model.entities.Barco;
import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import com.umanizales.api_batalla_naval.service.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "barco")
@Validated
public class BarcoController {
    private BarcoService barcoService;
    @Autowired
    public BarcoController(BarcoService barcoService) {
        this.barcoService = barcoService;
    }

    //Controlador para mostrar todos los barcos creados
    @GetMapping
    public @ResponseBody ResponseEntity<Object> findAll(){
        return barcoService.findAll();
    }
    //Controlador para crear barcos
    @PostMapping
    public @ResponseBody ResponseEntity<Object> createbarco(@RequestBody Barco barco){
        return barcoService.createbarco(barco);
    }
    //Controlador para actualizar un barco por id
    @PutMapping
    public @ResponseBody ResponseEntity<Object> updateBarco(@RequestBody Barco barco){
        return barcoService.updateBarco(barco);
    }
    //controlador para borrar un barco por id
    @DeleteMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<Object> deleteBarco(@PathVariable("id") int id){
        return barcoService.deleteBarco(id);
    }

}
