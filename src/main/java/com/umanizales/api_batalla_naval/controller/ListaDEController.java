package com.umanizales.api_batalla_naval.controller;

import com.umanizales.api_batalla_naval.model.dto.DistribuicionBarcoDTO;
import com.umanizales.api_batalla_naval.model.entities.Barco;
import com.umanizales.api_batalla_naval.service.ListaDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "listabarcos")
public class ListaDEController {
    private ListaDEService listaDEService;
    @Autowired
    public ListaDEController(ListaDEService listaDEService) {
        this.listaDEService = listaDEService;
    }
    @GetMapping
    public @ResponseBody ResponseEntity<Object> visualizarLista(){
        return listaDEService.visualizarListaDE();
    }
    @PostMapping
    public @ResponseBody ResponseEntity<Object> adicionarDistribuicionBarco(@RequestBody Barco barco){
        DistribuicionBarcoDTO distribucion = new DistribuicionBarcoDTO(barco);
        return listaDEService.adicionarBarco(distribucion);
    }
}
