package com.umanizales.api_batalla_naval.controller;

import com.umanizales.api_batalla_naval.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="jugador")
@Validated
public class playerController {
    private PlayerService playerService;
    @Autowired
    public playerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = "userByCodigo/{codigo}")
    public @ResponseBody ResponseEntity<Object> getUserByCodigo(@PathVariable("codigo") short codigo){
        return playerService.findUserByCodigo(codigo);
    }

    @GetMapping(path = "userByCorreo{correo}")
    public @ResponseBody ResponseEntity<Object> findUserByCorreo(@PathVariable("correo") String correo){
        return playerService.getUserByCorreo(correo);
    }

}
