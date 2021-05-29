package com.umanizales.api_batalla_naval.controller;

import com.umanizales.api_batalla_naval.model.dto.CoordenadaDTO;
import com.umanizales.api_batalla_naval.model.dto.SelecTablero;
import com.umanizales.api_batalla_naval.service.TableroService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "Tablero")
public class TableroController {
    private TableroService tableroService;

    public TableroController(TableroService tableroService) {
        this.tableroService = tableroService;
    }

    @PostMapping(path = "iniciar_tablero")
    public ResponseEntity<Object>crearTablero(@RequestBody SelecTablero selecTablero){
        return tableroService.createTablero(selecTablero.getNumElementos());
    }
    @GetMapping(path = "ver_tablero")
    public ResponseEntity<Object> visualizarTablero(){
        return tableroService.seeTablero();
    }
}
