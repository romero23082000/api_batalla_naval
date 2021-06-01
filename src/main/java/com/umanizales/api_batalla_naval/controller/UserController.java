package com.umanizales.api_batalla_naval.controller;

import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import com.umanizales.api_batalla_naval.service.PlayerService;
import com.umanizales.api_batalla_naval.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "Usuario")
@Validated
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping
    public @ResponseBody ResponseEntity<Object> findAll(){
        return userService.findAll();
    }
    @PostMapping
    public @ResponseBody ResponseEntity<Object> createUser(@RequestBody UsuarioEntity usuarioEntity){
        return userService.createUser(usuarioEntity);
    }
    @GetMapping(path = "{codigo}")
    public @ResponseBody ResponseEntity<Object>findUserByRol(@PathVariable("codigo") short codigo){
        return userService.findUserByRol(codigo);
    }

}
