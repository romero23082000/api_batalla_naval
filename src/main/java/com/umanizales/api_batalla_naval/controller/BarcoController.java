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

    @GetMapping
    public @ResponseBody ResponseEntity<Object> findAll(){
        return barcoService.findAll();
    }
    @PostMapping
    public @ResponseBody ResponseEntity<Object> createbarco(@RequestBody Barco barco){
        return barcoService.createbarco(barco);
    }

}
