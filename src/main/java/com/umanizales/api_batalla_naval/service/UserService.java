package com.umanizales.api_batalla_naval.service;

import com.umanizales.api_batalla_naval.model.dto.RespuestaDTO;
import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import com.umanizales.api_batalla_naval.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(new RespuestaDTO("EXITOSO",
                userRepository.findAll(), null), HttpStatus.OK);
    }
    public ResponseEntity<Object> createUser(UsuarioEntity usuarioEntity)
    {
        try {
            UsuarioEntity userSave = userRepository.save(usuarioEntity);
            return new ResponseEntity<>(new RespuestaDTO("EXITOSO",
                    userSave, null), HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO("ERROR",
                    null, "Ocurrio un error con el usuario"), HttpStatus.CONFLICT);
        }
    }
}
