package com.umanizales.api_batalla_naval.service;

import com.umanizales.api_batalla_naval.model.dto.RespuestaDTO;
import com.umanizales.api_batalla_naval.model.entities.TipoUsuarioEntity;
import com.umanizales.api_batalla_naval.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class PlayerService {
    private UserRepository userRepository;
    private TipoUsuarioEntity tipoUsuarioEntity;

    @Autowired
    public PlayerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
