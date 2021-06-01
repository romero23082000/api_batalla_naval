package com.umanizales.api_batalla_naval.controller;

import com.umanizales.api_batalla_naval.model.entities.Barco;
import com.umanizales.api_batalla_naval.model.entities.TipoUsuarioEntity;
import com.umanizales.api_batalla_naval.service.TypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "type_user_controller")
public class TypeUserController {
     private TypeUserService typeUserService;

     @Autowired
    public TypeUserController(TypeUserService typeUserService) {
        this.typeUserService = typeUserService;
    }
    //Controlador para mostrar todos los barcos creados
    @GetMapping
    public @ResponseBody
    ResponseEntity<Object> findAll(){
        return typeUserService.findAll();
    }
    //Controlador para crear barcos
    @PostMapping
    public @ResponseBody ResponseEntity<Object> createTypeUser(@RequestBody TipoUsuarioEntity tipoUsuarioEntity){
        return typeUserService.createTypeUser(tipoUsuarioEntity);
    }
}
